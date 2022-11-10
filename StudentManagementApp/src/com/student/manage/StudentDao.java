package com.student.manage;

import java.io.*;
import java.sql.*;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		
		boolean f = false;
		try {
			Connection con=CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);
			
			//SET THE VALUES
			pstm.setString(1,st.getStudentName());
			pstm.setString(2, st.getStudentPhone());
			pstm.setString(3, st.getStudentCity());
			
			//Execute Query
			pstm.executeUpdate();
			
			f = true;
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static boolean DeleteStudentToDB(int userId) {
		boolean f = false;
		try {
			Connection con=CP.createC();
			String q = "delete from students where sid = ?";
			
			//PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);
			
			//SET THE VALUES
			pstm.setInt(1,userId);
		
			
			//Execute Query
			pstm.executeUpdate();
			
			f = true;
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public static void DisplayTableToDB() {
		
		try {
			Connection con=CP.createC();
			String q = "select * from students;";
			
			//CreateStatement
			Statement stm = con.createStatement();
			ResultSet set = stm.executeQuery(q);
			
			//Execute Query
			
			System.out.println("==================");
			System.out.println("| STUDENT TABLE :|");
			System.out.println("==================");
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID :" + id);
				System.out.println("NAME :" + name);
				System.out.println("CITY :" + city);
				System.out.println("MOB NO. :" + phone);
				System.out.println();
				System.out.println("======================");
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean UpdateStudentToDB() throws NumberFormatException, IOException{
		boolean f = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			Connection con=CP.createC();
			String q = "update students set sname=? , sphone=? , scity=? where sid=? ";
			
			//SET THE VALUES
			System.out.println("ENTER NAME:");
			String Name = br.readLine();
			System.out.println("ENTER MOBILE NO. :");
			String phone = br.readLine();
			System.out.println("ENTER CITY :");
			String city = br.readLine();
			System.out.println("ENTER ID :");
			int userId = Integer.parseInt(br.readLine());
			
			//PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);
			
			pstm.setString(1,Name);
			pstm.setString(2,phone);
			pstm.setString(3,city);
			pstm.setInt(4,userId);
			
			
			//Execute Query
			pstm.executeUpdate();
			
			con.close();
			
			f = true;
		
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static void DisplayStudentToDB() throws NumberFormatException, IOException {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ENTER STUDENT ID :");
			int userId = Integer.parseInt(br.readLine());
		
		try {
			Connection con=CP.createC();
			String q = "select * from students where sid = ?;";
			
			//CreatePlatform
			
			PreparedStatement pstm = con.prepareStatement(q);
			
			//Set Values
			pstm.setInt(1,userId);
			
			ResultSet set = pstm.executeQuery();
			
			//Execute Query
			
			System.out.println("===================");
			System.out.println("| STUDENT DETAILS :|");
			System.out.println("===================");
			
			if(set.next())
			{
				
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID :" + userId);
				System.out.println("NAME :" + name);
				System.out.println("CITY :" + city);
				System.out.println("MOB NO. :" + phone);
				System.out.println();
				System.out.println("======================");
			}
			else
			{
				System.out.println("INVALID INPUT TRY AGAIN..");
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
