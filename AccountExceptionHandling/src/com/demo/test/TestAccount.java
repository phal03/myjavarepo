package com.demo.test;

import java.util.Scanner;

import com.demo.exception.AccountNotFoundException;
import com.demo.exception.ExceedingLimitException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class TestAccount {

	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		AccountService accountService = new AccountServiceImpl();
		do {
			System.out.println("MENU");
			System.out.println("Enter choice number : ");
			System.out.println("(1) Create new account.");
			System.out.println("(2) Withdraw from a particular account.");
			System.out.println("(3) Deposit to a particular account.");
			System.out.println("(4) Transfer of funds.");
			System.out.println("(5) Change pin number of of a particular account.");
			System.out.println("(6) Display account details by account id.");
			System.out.print("(7) Exit.\nEnter choice : ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:	try {
							accountService.createNewAccount();
						} catch (ExceedingLimitException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 2: System.out.println("Enter member id : ");
				 		int id = sc.nextInt();
				 		System.out.println("Enter balance to be withdrawn : ");
				 		double amt = sc.nextDouble();
				 		try {
				 			accountService.withdrawAmount(id, amt);
				 		} catch (InsufficientBalanceException e) {
				 			System.out.println(e.getMessage());
				 		} catch (AccountNotFoundException ex) {
				 			System.out.println(ex.getMessage());
				 		}
				 		break;
				case 3: System.out.println("Enter member id : ");
				 		id = sc.nextInt();
				 		System.out.println("Enter balance to be deposited : ");
				 		amt = sc.nextDouble();
				 		try {
				 			accountService.depositAmount(id, amt);
				 		} catch (AccountNotFoundException e) {
				 			System.out.println(e.getMessage());
				 		}
				 		break;
				case 4: System.out.println("Enter sender member id : ");
						id = sc.nextInt();
						System.out.println("Enter receiver member id : ");
						int rid = sc.nextInt();
						System.out.println("Enter balance to be transferred : ");
						amt = sc.nextDouble();
						try {
							accountService.transferAmount(id, rid, amt);
						} catch (InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						} catch (AccountNotFoundException ex) {
							System.out.println(ex.getMessage());
						}
						break;
				case 5:	System.out.println("Enter member id : ");
						id = sc.nextInt();
						try {
							accountService.changePinNum(id); 
						} catch (AccountNotFoundException e) {
							System.out.println(e.getMessage());
						} catch (ExceedingLimitException ex) {
							System.out.println(ex.getMessage());
						}
						break;
				case 6: System.out.println("Enter member id : ");
						id = sc.nextInt();
						try {
							accountService.displayMemberData(id);
						} catch (AccountNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 7: System.out.println("Thank you!!");
						break;
				default: System.out.println("Wrong choice of option!! Try again.");
			}
		}while(choice != 7);
		sc.close();
	}

}
