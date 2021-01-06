package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Costumer;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	public List<Employee> viewTransactions()
	{
		 List<Employee> tr = new ArrayList<>();
		String sql = "select trans_id, amount, first_name from bank.transactions"
				+ " left join bank.users"
				+ " on bank.users.user_id = bank.transactions.user_id";
				
		
		try (Connection c = ConnectionUtil.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int transId= rs.getInt("trans_id");
				double amount = rs.getDouble("amount");
				String userName = rs.getString("first_name");
				tr.add(new Employee(transId,amount,userName));
				
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tr;
			
	}
	
	
	
	
	public Costumer viewAccount(String userName) {
		// TODO Auto-generated method stub
		 Costumer u= null;
		String sql = "select * from bank.users where user_name=?";

		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,userName);
			 ResultSet rs =  ps.executeQuery();

			while(rs.next())
			{
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				String Usern = rs.getString("user_name");
				String userPass = rs.getString("user_pass");
				String applstatus = rs.getString("status");
				u= new Costumer(userId, firstName, lastName, balance, Usern, userPass, applstatus);
			}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  u;

	}
	
	public Costumer viewAccount(int id) {
		// TODO Auto-generated method stub
		 Costumer u= null;
		String sql = "select * from bank.users where user_id=?";

		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				String Usern = rs.getString("user_name");
				String userPass = rs.getString("user_pass");
				String applstatus = rs.getString("status");
				u= new Costumer(userId, firstName, lastName, balance, Usern, userPass, applstatus);
			}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;

	}
	
	public int Exist (int id)
	{
		
			String sql = "select user_id from bank.users where user_id=?";
			

				try (Connection c = ConnectionUtil.getConnection()) {
					PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
					if (!rs.wasNull())
						return 1;
					}
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  0;

		}
	
	public List<Costumer> viewPending()
	{
		{
			 List<Costumer> pendinglist = new ArrayList<>();
			String sql = "select * from bank.users where status = 'pending'";
					
			
			try (Connection c = ConnectionUtil.getConnection()) {
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while (rs.next()) {
					
					int userId = rs.getInt("user_id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					double balance = rs.getDouble("balance");
					String Usern = rs.getString("user_name");
					String userPass = rs.getString("user_pass");
					String applstatus = rs.getString("status");
					pendinglist.add(new Costumer(userId, firstName, lastName, 
							balance, Usern, userPass, applstatus));
					
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return pendinglist;
		}
	}

	
	public int addStatus(String addStatus, int user_id) {
		int status = 0;
		String sql = "update bank.users"
				+ " set status = ? where bank.users.user_id =?";
			
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			
			ps.setString(1, addStatus);
			ps.setInt(2, user_id);

			
			status = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int denyApplication(int id) {
		int denied = 0;
		String sql = "delete from bank.users where user_id = ?";
		
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			denied = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return denied;
	}
	
	
	
	
}
