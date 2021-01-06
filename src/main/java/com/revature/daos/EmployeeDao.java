package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Costumer;

public interface EmployeeDao {
	public List<Employee> viewTransactions();

	public List<Costumer> viewPending();
	
	public Costumer viewAccount(String userName);
	public Costumer viewAccount(int id);
	public int addStatus(String addStatus, int user_id);
	public int denyApplication(int id);
	public int Exist (int id);
}
