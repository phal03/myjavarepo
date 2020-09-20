package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;

public interface AccountDao {

	void addAccountData(Account acc);

	Account searchById(int id) throws AccountNotFoundException;

	void withdraw(Account acc, double amt) throws InsufficientBalanceException;

	void depositAmount(Account acc, double amt);

}
