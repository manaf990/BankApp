package com.revature.services;





import com.revature.daos.UsersDao;
import com.revature.daos.UsersPostgres;


public class UsersServices {
	
	
	private static UsersDao ud = new UsersPostgres();

	public String[] logIn (String userName)
	{
		return ud.logIn(userName);
		}

		

	
	public double viewBalanceById(int id) 
	{
		 double balance=ud.viewBalanceById(id);
			return balance;

	}
	public String deposit(double deposit, int id) {
	 int check = ud.depositById(deposit, id);
	 if(check!=0)
		return "deposit success of "+ deposit+" in Account ID = "+ id;
	 else return "deposit not success";
	}
	
	public String withdraw(double withdraw, int id) {
		 int check = ud.withdrawById(withdraw, id);
		 if(check!=0)
			return "withdraw success of "+ withdraw+" in Account ID = "+ id;
		 else return "withdraw not success";
		}
	
	public String transfer (double amount, int id, int toID) {
		 int check = ud.transferById(amount, id, toID);
		 if(check!=0)
			return "transaction success of "+ amount+" from Account ID = "+ id+ " to Account ID = "+ toID;
		 else return "transaction not success";
		}
	

	

	


}
