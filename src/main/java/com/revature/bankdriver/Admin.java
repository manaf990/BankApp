package com.revature.bankdriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.services.EmployeeServices;
import com.revature.util.ConnectionUtil;

 final class Admin {
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Connection c = ConnectionUtil.getConnection();
			String driverName = c.getMetaData().getDriverName();
			System.out.println(driverName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
			int accountCreated = 0;
			String sql = "insert into bank.users (first_name, last_name,  balance, user_name, user_pass, status)"
					+ " values (?,?,?,?,?,?)";
				
			try (Connection c = ConnectionUtil.getConnection()) {
				PreparedStatement ps = c.prepareStatement(sql);
				
				ps.setString(1, "Admin");
				ps.setString(2, "Admin");
		
				ps.setDouble(3, 0);
				ps.setString(4, "admin2");
				ps.setString(5, "a123456");
				ps.setString(6, "employee");

				
				accountCreated = ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 System.out.print("Admin account created " + accountCreated);

			
	}}


