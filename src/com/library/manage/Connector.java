package com.library.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

	static Connection con;

	public static Connection createC() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String user = "root";
			String password = "sHiv@#1234#@";
			String url = "jdbc:mysql://localhost:3306/bank_management";

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
