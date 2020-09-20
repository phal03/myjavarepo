package com.demo.bean;

import com.demo.exception.InsufficientBalanceException;

abstract public class Account {
	static {
		cnt = 0;
	}
	public static int cnt;
	private int memId;
	private String memName;
	protected double balance;
	private int mobile;
	private String email;
	private int pinNumber;
	
	//Default constructor
	public Account() {
		memId = ++cnt;
		memName = null;
		balance = 0.0;
		mobile = 0;
		email = null;
		pinNumber = 0;
	}
	
	//Parameterized constructor
	public Account(String memName, double balance, int mobile, String email, int pinNumber) {
		this.memId = ++cnt;
		this.memName = memName;
		this.balance = balance;
		this.mobile = mobile;
		this.email = email;
		this.pinNumber = pinNumber;
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
	public int getMobile() {
		return this.mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPinNumber() {
		return this.pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Member id : " + memId + "\nMember name : " + memName + "\nBalance : " + balance + "\nMobile Number : " + mobile + "\nEmail : " + email + "\nPin Number : " + pinNumber;
	}
	
	abstract public void withdraw(double amt) throws InsufficientBalanceException;

	abstract public void calculateInterest(double amt);
	
	public void deposit(double amt) {
		balance = balance + amt;
	}

}


