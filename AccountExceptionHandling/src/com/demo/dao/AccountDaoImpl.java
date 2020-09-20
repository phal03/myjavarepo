package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;

public class AccountDaoImpl implements AccountDao{
	static Account arr[];   
	static int count;
	static {
		arr = new Account[3];
		count = 0;
	}
	
	@Override
	public void addAccountData(Account acc) {
		arr[count] = acc;
		count++;
	}

	@Override
	//search a particular account by member id
	public Account searchById(int id) throws AccountNotFoundException {
		// for loop returns the requested account in the Account array
		for(Account a : arr) {
			if(a != null) {
				if(a.getId() == id)
					return a;
			}
			else
				throw new AccountNotFoundException("Account not found!!");
		}
		return null;
	}

	@Override
	public void withdraw(Account acc, double amt) throws InsufficientBalanceException{
		acc.withdraw(amt);
		
	}

	@Override
	public void depositAmount(Account acc, double amt) {
		acc.deposit(amt);
		
	}
}