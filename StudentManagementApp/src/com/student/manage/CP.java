package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CP {
	
	static Connection con;
	public static Connection createC(){
		
		try {
			
			//LOAD DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//CREATE CONNECTION
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String uname = "root";
			String pass ="root";
			con = DriverManager.getConnection(url,uname,pass);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
