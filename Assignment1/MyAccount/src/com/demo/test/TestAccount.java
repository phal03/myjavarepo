package com.demo.test;

import com.demo.bean.*;
import com.demo.service.*;
import java.util.Scanner;

public class TestAccount {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Account[] at = new Account[10];
		int choice;
		do {
			System.out.print("MENU\nEnter the option :\n(1) to create new accounts\n(2) to withdraw amount\n(3) to deposit amount\n(4) to display details\n(5) to exit. \nEnter choice : ");
			choice = sc.nextInt();
			switch(choice) {
				case 1 : AccountService.acceptMemberData(at);
						 break;
				case 2 : System.out.println("Enter member id : ");
						 int id = sc.nextInt();
						 System.out.println("Enter balance to be withdrawn : ");
						 double bal = sc.nextDouble();
						 AccountService.withdrawAmount(at, id, bal);
						 break;
				case 3 : System.out.println("Enter member id : ");
						 id = sc.nextInt();
						 System.out.println("Enter balance to be deposited : ");
						 bal = sc.nextDouble();
						 AccountService.depositAmount(at, id, bal);
						 break;
				case 4 : System.out.println("Enter member id : ");
						 id = sc.nextInt();
						 AccountService.displayMemberData(at, id);
						 break;
				case 5 : System.exit(0);
						 break;
				default : System.out.println("Wrong choice!!");
			}
		}while(choice != '5');
		sc.close();
	}
}
