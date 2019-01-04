package com.zilker.jdbc;
import java.util.Scanner;
import java.util.logging.*;

import com.zilker.beans.Student;
import com.zilker.dao.StudentDAO;

/*
 * 
 */
public class JDBC {
	
	private static final Logger logger = Logger.getLogger(JDBC.class.getName());
	
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		try {
			StudentDAO studentDAO = new StudentDAO();
			System.out.print("Enter the regID: ");
			String regID = scn.next();
			Student student = new Student(regID, "Raxit", "Jain", "rjain@ztech.io");
			studentDAO.insertStudent(student);
			studentDAO.displayStudent(regID);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		} finally {
			scn.close();
		}
	}

}
