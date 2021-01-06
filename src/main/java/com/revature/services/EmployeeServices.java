package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;

import com.revature.models.Employee;
import com.revature.models.Costumer;

public class EmployeeServices {

	private static EmployeeDao ed = new EmployeePostgres();
	
	public  List<Employee> viewAllTransactions()
	{
		return ed.viewTransactions();
	}
	
	public  List<Costumer> viewPending()
	{
		return ed.viewPending();
	}
	
	public Costumer viewAccount(String userName){
		return ed.viewAccount(userName);
	} 
	
	public Costumer viewAccount(int id){
		return ed.viewAccount(id);
	} 
	
	public boolean Exist (int id)
	{
		int check = ed.Exist(id);
		if(check != 0) 
			return true;
		 else
		
			return false;
		

	}
	

	public boolean addStatus(String status, int id){
		int statusAdded = ed.addStatus(status, id);
		if(statusAdded != 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean denyApplication(int id) 
	{
		 int deny = ed.denyApplication(id);
		 if (deny !=0)
		 return true;
		 
		 else return false;
		 
	}
	
}