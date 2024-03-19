package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class EmployeeController {

	// statement interface....
	// 1000k --> 1 c -->1ms ---> 1e 1ms -->2000 ms
	/// preCompile query

	public void addEmployee() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {
			try {
				String insertSQL = "insert into employee (ename,eemail,eage,epassword)values(?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				Scanner sc = new Scanner(System.in);
				System.out.println("enter employee Name");
				String eName = sc.next();
				System.out.println("enter employee Email");
				String eEmail = sc.next();
				System.out.println("enter employee Password");
				String ePassword = sc.next();
				System.out.println("enter employee age");
				int eAge = sc.nextInt();
				
//				pstmt.setString(1, "raj");
//				pstmt.setString(2, "raj@gmail.com");
//				pstmt.setInt(3, 23);
//				pstmt.setString(4, "raj@123");

				pstmt.setString(1, eName);
				pstmt.setString(2, eEmail);
				pstmt.setInt(3, eAge);
				pstmt.setString(4, ePassword);

				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("Employee inserted..");
				}
				else {
					System.out.println("employee not inserted..");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void updateEmployee() {
		
		Connection conn =DBConnection.getDBConnection();
		if(conn!=null) {
			
			String updateSQL = "update employee set ename =?,eemail =?,eage = ?,epassword =? where eid = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "RAJ");
				
				pstmt.setString(2, "raj@gmail.co.in");
				pstmt.setInt(3, 24);
				pstmt.setString(4, "raj@123");
				pstmt.setInt(5, 1);
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					
					System.out.println("Employee updated..");
				}
				else {
					System.out.println("employee not updated...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {

		EmployeeController employeeController = new EmployeeController();
		//employeeController.addEmployee();
		employeeController.updateEmployee();
	}
}
