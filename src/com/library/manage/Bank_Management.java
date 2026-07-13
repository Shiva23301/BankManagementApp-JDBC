package com.library.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bank_Management {

	public static boolean insertToDb(Bank bank) {
		boolean f = false;

		try {

			Connection con = Connector.createC();

			String q = "insert into bank(accountNo, name, balance) values(?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, bank.getAccountNo());
			pstmt.setString(2, bank.getName());
			pstmt.setInt(3, bank.getBalance());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public static boolean depositToAcc(Bank bank) {
		boolean f = false;

		try {

			Connection con = Connector.createC();

			String q = "update bank set balance=balance+? where accountNo=?";

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, bank.getBalance());
			pstmt.setInt(2, bank.getAccountNo());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public static boolean withdrawFromAcc(Bank bank) {

		boolean f = false;

		try {

			Connection con = Connector.createC();

			String q = "update bank set balance=balance-? where accountNo=?";

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, bank.getBalance());
			pstmt.setInt(2, bank.getAccountNo());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return f;
	}

	public static void checkBalanceInAcc(int accountNo) {

		try {

			Connection con = Connector.createC();

			String q = "select balance from bank where accountNo=?";

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, accountNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Current balance: " + rs.getInt("balance"));
				System.out.println();
			} else {
				System.out.println("Acount not found");
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean deleteAcc(int accountNo) {

		boolean f = false;

		try {

			Connection con = Connector.createC();

			String q = "delete from bank where accountNo=?";

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, accountNo);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllAcc() {

		try {

			Connection con = Connector.createC();

			String q = "select * from bank";

			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {
				int accountNo = set.getInt(1);
				String name = set.getString(2);
				int balance = set.getInt(3);

				System.out.println("Account No: " + accountNo);
				System.out.println("Name: " + name);
				System.out.println("Balance: " + balance);
				System.out.println("-----------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
