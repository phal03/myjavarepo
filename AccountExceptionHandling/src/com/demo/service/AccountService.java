package com.demo.service;

import com.demo.exception.AccountNotFoundException;
import com.demo.exception.ExceedingLimitException;
import com.demo.exception.InsufficientBalanceException;

public interface AccountService {

	void createNewAccount() throws ExceedingLimitException;

	void withdrawAmount(int id, double amt) throws InsufficientBalanceException, AccountNotFoundException;

	void depositAmount(int id, double amt) throws AccountNotFoundException;

	void transferAmount(int id, int rid, double amt) throws InsufficientBalanceException, AccountNotFoundException;

	void changePinNum(int id) throws AccountNotFoundException, ExceedingLimitException;

	void displayMemberData(int id) throws AccountNotFoundException;

}
