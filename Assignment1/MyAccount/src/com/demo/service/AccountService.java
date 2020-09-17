package com.demo.service;
import com.demo.bean.*;
import java.util.Scanner;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountService {
	public static Scanner sc = new Scanner(System.in);

	//accept data for n customers
	public static void acceptMemberData(Account at[]) {
		for(int i = 0; i < at.length; i++) {
			System.out.println("Enter member name : ");
			String nm = sc.next();
			System.out.println("Enter account type : ");
			String tp = sc.next();
			System.out.println("Enter balance : ");
			double bal = sc.nextDouble();
			at[i] = new Account(nm, new Date(), tp, bal);
		}
	}
	
	//withdrawal of amount from a particular account
	public static void withdrawAmount(Account at[], int id, double bal) {
		int index = searchById(at, id);
		if(index != -1) {
			at[index].withdraw(bal);
			System.out.println("Withdraw Successful!!");
		}
		else
			System.out.println("Account not found!!");
	}
	
	//deposit amount to a particular amount
	public static void depositAmount(Account at[], int id, double bal) {
		int index = searchById(at, id);
		if(index != -1) {
			at[index].deposit(bal);
			System.out.println("Deposit Successful!!");
		}
		else
			System.out.println("Account not found!!");
	}
	
	
	//display data of a particular account
	public static void displayMemberData(Account at[], int id) {
		int index = searchById(at, id);
		if(index != -1)
			System.out.println("Details : \n" + at[index]);
		else
			System.out.println("Account not found!!");
	}
	
	//search a particular account by member id
		public static int searchById(Account at[], int id) {
			// for loop returns the position of the requested account in the Account array
			for(int i = 0; i < at.length; i++) {
				if(at[i].getId() == id)
					return i;
			}
			return -1;
		}
}

