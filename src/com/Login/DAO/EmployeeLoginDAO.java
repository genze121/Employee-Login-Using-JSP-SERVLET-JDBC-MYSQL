package com.Login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Login.Connection.DBConnectionProvider;
import com.Login.Entity.EmployeeLogin;

public class EmployeeLoginDAO {

	// SQL QUERY to retrieve the login details from DB
	private static final String SELECT_SQL_QUERY = "select * from login where email=? and pass=?";

	public EmployeeLogin getLoginDetails(EmployeeLogin login) {

		boolean flag = false;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet result = null;
		EmployeeLogin emplogin = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_SQL_QUERY);
			System.out.println(preparedStatement);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			result = preparedStatement.executeQuery();
			while (result.next()) {
				emplogin = new EmployeeLogin();
				emplogin.setEmail(result.getString("email"));
				emplogin.setPassword(result.getString("pass"));
			}

		} catch (SQLException e) {
			DBConnectionProvider.printSQLException(e);
		}

		return emplogin;

	}

}
