package com.demo.bean;
import com.demo.exception.InsufficientBalanceException;
public class CurrentAccount extends Account{
	final public static float interestRate;
	private int numOfTransactions;
	private double interest;
	static {
		interestRate = 1.0f;
	}
	
	public CurrentAccount() {
		System.out.println("Default Constructor for Current Account.");
		numOfTransactions = 0;
	}
	
	public CurrentAccount(String memName, double balance, int mobile, String email, int pinNumber) {
		super(memName, balance, mobile, email, pinNumber);
		System.out.println("Parameterized constructor for Current Account.");
		this.numOfTransactions = 0;
		
	}
	
	
	public int getNumOfTransactions() {
		return numOfTransactions;
	}

	public void setNumOfTransactions(int numOfTransactions) {
		this.numOfTransactions = numOfTransactions;
	}

	@Override
	public void withdraw(double amt) throws InsufficientBalanceException{
		if(balance >= amt) {
			balance = balance - amt;
			System.out.println("Withdrawal successful");
			numOfTransactions++;
		}
		else
			throw new InsufficientBalanceException("Withdrawal not possible. Amount in account cannot be 0.");
	}

	@Override
	public void calculateInterest(double amt) {
		interest = amt * interestRate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nAccount type : Current \nInterest Rate : " + interestRate + "\nNumber of Transactions : " + numOfTransactions + "\nInterest amount : " + interest;
	}
}
