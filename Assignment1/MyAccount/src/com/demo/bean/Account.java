package com.demo.bean;

import java.util.Date;

public class Account {
	static {
		cnt = 0;
	}
	public static int cnt;	//for auto generating member id
	private int memId;
	private String memName;
	private Date openDate;
	private String accType;
	private double balance;
	
	//Default constructor
	public Account() {
		memId = ++cnt;
		memName = null;
		openDate = null;
		accType = null;
		balance = 0.0;
	}
	
	//Parameterized constructor
	public Account(String memName, Date openDate, String accType, double balance) {
		this.memId = ++cnt;
		this.memName = memName;
		this.openDate = openDate;
		this.accType = accType;
		this.balance = balance;
	}
	
	//setter and getter methods
	public int getId() {
		return this.memId;
	}
	public void setMemName(String name) {
		this.memName = name;
	}
	public String getMemName() {
		return this.memName;
	}
	public void setOpenDate(Date dt) {
		this.openDate = dt;
	}
	public Date getOpenDate() {
		return this.openDate;
	}
	public void setAccType(String type) {
		this.accType = type;
	}
	public String getAccType() {
		return this.accType;
	}
	public void setBalance(double bal) {
		this.balance = bal;
	}
	public double getBalance() {
		return this.balance;
	}
	
	//Overriding toString() of Object Class to print details
	@Override
	public String toString() {
		return "Member id : " + memId + "\nMember name : " + memName + "\nAccount openeing date : " + openDate + "\nAccount Type : " + accType + "\nBalance : " + balance;
	}
	
	//Withdrawal of amount from a particular amount
	public void withdraw(double amt) {
		if(balance - 10000 >= amt)
			 balance = balance - amt;
		else
			System.out.println("Not enough balance!!");
	}
	
	
	//Deposit of amount to a particular account
	public void deposit(double amt) {
		balance = balance + amt;
	}
}
