package com.fanniemae.www.accounting.accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO implements IAccountDAO {

	public boolean create(String name, double accountBalance) throws ClassNotFoundException, SQLException {
		String insertQuery = "INSERT INTO SDET404.ACCOUNT VALUES (ACCOUNT_ID_SEQ.NEXTVAL,ACCOUNT_NO_SEQ.NEXTVAL,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int successCode;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sdet404", "password");
			stmt = conn.prepareStatement(insertQuery);
			stmt.setString(1, name);
			stmt.setDouble(2, accountBalance);
			successCode = stmt.executeUpdate();
		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}
		if (successCode > 0)
			return true;
		return false;
	}

	public boolean update(Integer accountID, double accountBalance) throws ClassNotFoundException, SQLException {
		String updateQuery = "UPDATE SDET404.ACCOUNT SET ACCOUNT_BALANCE=? WHERE ACCOUNT_ID=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int successCode;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sdet404", "password");
			stmt = conn.prepareStatement(updateQuery);
			stmt.setDouble(1, accountBalance);
			stmt.setInt(2, accountID);
			successCode = stmt.executeUpdate();
		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}
		if (successCode > 0)
			return true;
		return false;
	}

}
