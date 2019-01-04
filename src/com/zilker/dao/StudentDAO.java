package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zilker.beans.Student;
import com.zilker.utils.DBUtils;

public class StudentDAO {
	
	private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/*
	 * 
	 */
	public void insertStudent (Student student) {
		try {
			conn = DBUtils.getConnection();
			pst = conn.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			pst.setString(1, student.getRegID());
			pst.setString(2, student.getFirstName());
			pst.setString(3, student.getLastName());
			pst.setString(4, student.getEmail());
			int count = pst.executeUpdate();
			logger.log(Level.INFO, "Number of rows affected: " + count);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error inserting student details");
		} finally {
			DBUtils.closeConnection(conn, pst, rs);
		}
	}
	
	public void displayStudent (String regID) {
		try {
			conn = DBUtils.getConnection();
			pst = conn.prepareStatement("SELECT * FROM STUDENT WHERE REG_ID=?");
			pst.setString(1, regID);
			rs = pst.executeQuery();
			while (rs.next()) {
				logger.log(Level.INFO, "RegID: " + rs.getString("REG_ID") + "\nFirst Name: " + rs.getString("FIRST_NAME") + 
						"\nLast Name: " + rs.getString("LAST_NAME") + "\nEmail: " + rs.getString("EMAIL"));
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error displaying student details");
		} finally {
			DBUtils.closeConnection(conn, pst, rs);
		}
	}

}
