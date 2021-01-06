package com.revature.daos;

import com.revature.models.Costumer;

public interface CostumerDao {
	
	
	public String[] logIn(String userName);


	public double viewBalanceById(int id);
	public int depositById( double deposit, int id);
	public int withdrawById(double withdraw, int id);
	public int transferById(double amount, int id, int toID);
	public int applyForAccount(Costumer u);

	
	
	
}
