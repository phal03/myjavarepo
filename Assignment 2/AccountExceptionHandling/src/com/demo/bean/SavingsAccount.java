package com.demo.bean;

import com.demo.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	final public static float interestRate;
	private String chequeBookNum;
	private double interest;
	static {
		interestRate = 4.4f;
	}
	
	public SavingsAccount() {
		System.out.println("Default Constructor for Savings Account.");
		chequeBookNum = "CHQ" + this.getId();
	}
	
	public SavingsAccount(String memName, double balance, int mobile, String email, int pinNumber) {
		super(memName, balance, mobile, email, pinNumber);
		System.out.println("Parameterized constructor for Savings Account.");
		chequeBookNum = "CHQ" + this.getId();
	}
	

	@Override
	public void withdraw(double amt) throws InsufficientBalanceException{
		if(balance - amt < 10000) 
			throw new InsufficientBalanceException("Withdrawal not possible. Minimum amount in account should be 10000.");
		else {
			balance = balance - amt;
			System.out.println("Withdrawal successful");
		}
	}

	@Override
	public void calculateInterest(double amt) {
		interest = amt * interestRate + 0.02 * amt;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nAccount type : Savings \nInterest Rate : " + interestRate + "\nCheque Book Number : " + chequeBookNum + "\nInterest Amount : " + interest;
	}
	
}
