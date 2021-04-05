package com.Login.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionProvider {

	// URL,Username and Password of MYSQL DB
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_login";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// Adding up the Driver for MYSQL DB
	private static String JDBC_DRIVER;
	static {
		try {
			JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Connecting to the MYSQL DB
	@SuppressWarnings("unused")
	public static Connection getConnection() {
		Connection con = null;
		try {
			if (con == null) {
				con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				System.out.println("Connected to the DB successfully!!!");
			} else {
				System.out.println("Something went wrong.Please check again!!");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return con;

	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL State:- " + ((SQLException) e).getSQLState());
				System.err.println("Error Code:- " + ((SQLException) e).getErrorCode());
				System.err.println("Message:- " + ((SQLException) e).getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					t = t.getCause();
				}
			}
		}
	}

	public static void closeResources(PreparedStatement ps, Connection con) {

		try {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}

			if (con != null && !con.isClosed()) {
				con.close();
			}
			System.out.println("Connection is closed successfully!!");
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

}
