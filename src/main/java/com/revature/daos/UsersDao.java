package com.revature.daos;




public interface UsersDao {
	
	
	public String[] logIn(String userName);


	public double viewBalanceById(int id);
	public int depositById( double deposit, int id);
	public int withdrawById(double withdraw, int id);
	public int transferById(double amount, int id, int toID);
	

	
	
	
}
