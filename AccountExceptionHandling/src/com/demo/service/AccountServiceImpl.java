package com.demo.service;

import java.util.Scanner;

import com.demo.bean.*;
import com.demo.dao.*;
import com.demo.exception.*;


public class AccountServiceImpl implements AccountService{
	static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}
	private AccountDao accountDao;
	
	public AccountServiceImpl() {
		this.accountDao = new AccountDaoImpl();
	}
	
	@Override
	public void createNewAccount() throws ExceedingLimitException {
		Account acc = null;
		System.out.print("Enter Name : ");
		String nm = sc.nextLine();
		System.out.print("\nEnter Mobile Number : ");
		int mob = sc.nextInt();
		System.out.print("\nEnter Email id : ");
		String email = sc.next();
		System.out.print("\nEnter Account Pin : ");
		int pin = sc.nextInt();
		System.out.println("\nEnter balance of account : ");
		double bal = sc.nextDouble();
		
		// 3 try to enter correct details
		int i = 0;
		for(; i < 3; i++) {
			System.out.print("\nEnter type of account : \"sav\" for Savings Account or \"curr\" for Current Account : ");
			String type = sc.next();
			if(type.equals("sav")) {
				acc = new SavingsAccount(nm, bal, mob, email, pin);
				accountDao.addAccountData(acc);
				break;
			}
			else if(type.equals("curr")) {
				acc = new CurrentAccount(nm, bal, mob, email, pin);
				accountDao.addAccountData(acc);
				break;
			}
			if(i == 2)
				throw new ExceedingLimitException("Attempts number exceeded!!");
		}
		System.out.println("Account created successfully !!");
	}

	@Override
	public void withdrawAmount(int id, double amt) throws InsufficientBalanceException, AccountNotFoundException {
		Account acc = accountDao.searchById(id);
		if(acc != null) 
			accountDao.withdraw(acc, amt);
		else
			throw new AccountNotFoundException("Acccount Not Found!!");
	}

	@Override
	public void depositAmount(int id, double amt) throws AccountNotFoundException {
		Account acc = accountDao.searchById(id);
		if(acc != null) {
			accountDao.depositAmount(acc, amt);
			if(acc.getClass() == CurrentAccount.class) 
				((CurrentAccount)acc).setNumOfTransactions(((CurrentAccount)acc).getNumOfTransactions() + 1);
		}
		else
			throw new AccountNotFoundException("Account not found!!");
	}

	@Override
	public void transferAmount(int id, int rid, double amt) throws InsufficientBalanceException, AccountNotFoundException {
		Account sendAcc = accountDao.searchById(id);
		if(sendAcc != null) {
			Account recAcc = accountDao.searchById(rid);
			if(recAcc != null) {
				accountDao.withdraw(sendAcc, amt);
				accountDao.depositAmount(recAcc, amt);
			}
			else 
				throw new AccountNotFoundException("Receiver account not found!!");
		}
		else
			throw new AccountNotFoundException("Sender account not found!!");
	}

	@Override
	public void changePinNum(int id) throws AccountNotFoundException, ExceedingLimitException {
		Account acc = accountDao.searchById(id);
		if( acc != null) {
			//3 try to input correct pin
			for(int i = 0; i < 3; i++) {
				System.out.println("Enter old pin number : ");
				int pin = sc.nextInt();
				if(acc.getPinNumber() == pin) {
					System.out.println("Enter new pin number : ");
					int newPinNumber = sc.nextInt();
					acc.setPinNumber(newPinNumber);
					System.out.println("Pin number updated successfully!!");
					break;
				}
				else
					System.out.println("Incorrect pin!!\nChances left : " + (i + 1));
				if(i == 2)
					throw new ExceedingLimitException("Attempts number exceeded!!");
			}
		}	
		else
			throw new AccountNotFoundException("Account not found!!");
	}

	@Override
	public void displayMemberData(int id) throws AccountNotFoundException {
		Account acc = accountDao.searchById(id);
		if(acc != null)
			acc.toString();
		else
			throw new AccountNotFoundException("Account not found!!");
		
	}
	
}
