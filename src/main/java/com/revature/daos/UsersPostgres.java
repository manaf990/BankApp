package com.revature.daos;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class UsersPostgres implements UsersDao {



	@Override
	public double viewBalanceById(int id) {
		// TODO Auto-generated method stub
		double balance=0;
		String sql = "select  balance from bank.users where user_id =?";
		
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
			
			balance=rs.getDouble("balance");
	}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return balance;
}

	@Override

		// TODO Auto-generated method stub
		public int depositById(double deposit, int id) {
			String sql = "{call bank.deposit(?,?)}";
			int check=0;
			try (Connection c = ConnectionUtil.getConnection()){
				CallableStatement cs = c.prepareCall(sql);
				cs.setBigDecimal(1, new BigDecimal(deposit));
				cs.setInt(2, id);
				
				cs.execute();
				
				
				String sql2 = "insert into bank.transactions (amount, user_id)"
						+ " values (?,?)";
					
					PreparedStatement ps = c.prepareStatement(sql2);
					
					ps.setBigDecimal(1, new BigDecimal(deposit));
					ps.setInt(2, id);
				check = ps.executeUpdate();
			}			
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			
			return check;
		}
	
	public String[] logIn(String userName)
	{
		
		String[] login= new String[2];
		String sql = "SELECT user_name, user_pass from bank.users where user_name = ?";
		try(Connection c= ConnectionUtil.getConnection())
		{
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
		
			
			rs.next();
				
				login[0]=rs.getString("user_name");
			
			
				login[1] = rs.getString("user_pass");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return login;
	}

	@Override
	public int withdrawById(double withdraw, int id) {
		String sql = "{call bank.withdraw(?,?)}";
		int check=0;
		try (Connection c = ConnectionUtil.getConnection()){
			CallableStatement cs = c.prepareCall(sql);
			cs.setBigDecimal(1, new BigDecimal(withdraw));
			cs.setInt(2, id);
			
			cs.execute();
			
			
			String sql2 = "insert into bank.transactions (amount, user_id)"
					+ "values (?,?)";
				
				PreparedStatement ps = c.prepareStatement(sql2);
				
				ps.setBigDecimal(1, new BigDecimal(-withdraw));
				ps.setInt(2, id);
			check = ps.executeUpdate();
		}			
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		return check;
		
	}

	@Override
	public int transferById(double amount, int id, int toID) {
		// TODO Auto-generated method stub
		int check = 0;
		String sql = " UPDATE bank.users set balance = (balance - ?) where user_id = ?;"
				+ "UPDATE bank.users set balance = (balance + ?) where user_id = ?;"
				+ "INSERT INTO bank.transactions(amount, user_id) values(?,?);"
				+ "INSERT INTO bank.transactions(amount, user_id) values(?,?)";
		try(Connection c = ConnectionUtil.getConnection() )
		{
			PreparedStatement ps =c.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.setDouble(3, amount);
			ps.setInt(4, toID);
			ps.setDouble(5, -amount);
			ps.setInt(6, id);
			ps.setDouble(7, amount);
			ps.setInt(8, toID);
			check = ps.executeUpdate();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}


	

		
		
	}




	

	

