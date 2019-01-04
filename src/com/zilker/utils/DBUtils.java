package com.zilker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
	
	private static final Logger logger = Logger.getLogger(DBUtils.class.getName());
	private static final String connectionString = "jdbc:mysql://localhost:3306/sample";
	private static final String username = "root";
	private static final String password = "raxit1997";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error connecting with SQL Driver");
		}
		return conn;
	}
	
	public static void closeConnection (Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pst != null) {
				pst.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error closing the connection variables");
		}
	}
	
}
