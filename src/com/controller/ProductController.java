package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class ProductController {

	// statemanet creation

	public void addProduct() {

		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		if (conn != null) {

			// statement creation

			try {
				Statement stmt = conn.createStatement();
				// query preapration..
				System.out.println("enter product Name");
				String pName = sc.next();
				System.out.println("enter product price");
				int pprice = sc.nextInt();
				System.out.println("enter product qty");
				int pqty = sc.nextInt();
				System.out.println("enter prod disc");
				float pdisc = sc.nextFloat();

				// String INSERTSQL = "insert into
				// product(pname,pprice,pqty,discount)values('iphone15',12000,1,10.0)";
				String INSERTSQL = "insert into product(pname,pprice,pqty,discount)values('" + pName + "'," + pprice
						+ "," + pqty + "," + pdisc + ")";

				// submit...
				// 4 methods are there to submit query...
				// 1)executeUpdate() -->int
				// 2)executeLongUpdate -->long
				// 3)execute() --->boolean -->DDL -->true ,DML -->false
				// 4)executeQuery() ->ResultSet interface DDL -->

				int res = stmt.executeUpdate(INSERTSQL);
				if (res > 0) {
					System.out.println("rows " + res + " insterted...");
				} else {
					System.out.println("No rows inserted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void deleteProduct() {
		
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			
			String DELETESQL = "delete from product where pid = 1";
			try {
				Statement stmt = conn.createStatement();
				boolean res  =stmt.execute(DELETESQL);
				System.out.println(res);
						
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
	}

	public static void main(String[] args) {

		ProductController productController = new ProductController();
		//productController.addProduct();
		productController.deleteProduct();

	}
}
