package com.library.manage;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {

		System.out.println("Welcome to the Bank Management App");

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("PRESS 1 TO CREATE ACCOUNT");
			System.out.println("PRESS 2 TO DEPOSIT");
			System.out.println("PRESS 3 TO WITHDRAW");
			System.out.println("PRESS 4 TO CHECK BALANCE");
			System.out.println("PRESS 5 TO DELETE ACCOUNT");
			System.out.println("PRESS 6 TO SHOW ALL ACCOUNT");
			System.out.println("PRESS 7 TO EXIT");

			int ch = sc.nextInt();
			sc.nextLine();

			if (ch == 1) {

				System.out.print("Enter your accountNo: ");
				int accountNo = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter your name: ");
				String name = sc.nextLine();

				System.out.print("Enter your balance: ");
				int balance = sc.nextInt();

				Bank bank = new Bank(accountNo, name, balance);

				boolean ans = Bank_Management.insertToDb(bank);

				if (ans) {
					System.out.println("Create account successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			}

			else if (ch == 2) {

				System.out.print("Enter accountNo to Deposit: ");
				int accountNo = sc.nextInt();

				System.out.print("Enter value to Deposit: ");
				int balance = sc.nextInt();

				Bank bank = new Bank(accountNo, balance);

				boolean f = Bank_Management.depositToAcc(bank);

				if (f) {
					System.out.println("Successfully deposit...");
				} else {
					System.out.println("Something wrong...");
				}
			}

			else if (ch == 3) {

				System.out.print("Enter accountNo to Withdraw: ");
				int accountNo = sc.nextInt();

				System.out.print("Enter balance to Withdraw: ");
				int balance = sc.nextInt();

				Bank bank = new Bank(accountNo, balance);

				boolean f = Bank_Management.withdrawFromAcc(bank);

				if (f) {
					System.out.println("Balance Withdraw successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			}

			else if (ch == 4) {

				System.out.print("Enter accountNo to check Balance: ");
				int accountNo = sc.nextInt();

				Bank_Management.checkBalanceInAcc(accountNo);
			}

			else if (ch == 5) {

				System.out.print("Enter accountNo to delete account: ");
				int accountNo = sc.nextInt();

				boolean ans = Bank_Management.deleteAcc(accountNo);

				if (ans) {
					System.out.println("Account delete successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			}

			else if (ch == 6) {

				Bank_Management.showAllAcc();
			}

			else if (ch == 7) {
				break;
			}
		}

		System.out.println("Thank you for using...");
		System.out.println("Bye Bye...");

	}

}
