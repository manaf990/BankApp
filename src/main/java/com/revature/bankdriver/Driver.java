package com.revature.bankdriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Costumer;
import com.revature.services.CostumerServices;
import com.revature.services.EmployeeServices;
import com.revature.util.ConnectionUtil;

public class Driver  {
	
	private static Logger log = LogManager.getRootLogger();
	private static CostumerServices cs= new CostumerServices();
	private static EmployeeServices es= new EmployeeServices();
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
		try {
			
			Connection c = ConnectionUtil.getConnection();
			String driverName = c.getMetaData().getDriverName();
			System.out.println(driverName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Costumer u=null;

		int check=1;
		
		maincheck:
			while (check ==1 )
			{
				System.out.println("Enter 1 to login\nEnter 2 to apply for an account"
						+ "\nEnter 3 to Exit");
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				int hello= sc.nextInt();
				
		switch(hello)
		{
		case 1:
			
			System.out.println("Enter User Name");
			String userName= sc.next().toLowerCase();
			String[] ar=cs.logIn(userName);

			System.out.println("Enter User Password");
			String userPass= sc.next();
			
			if (ar[1] !=null)
			{
			
		if(ar[0].equalsIgnoreCase(userName) && ar[1].equals(userPass) 
				&& es.viewAccount(userName).getStatus().equals("costumer"))
		{
			
			log.error(userName);
			log.error("signed in");
			int id = es.viewAccount(userName).getUser_id();
			
			String menu="Enter 1 to view balance "
					+ "\nEnter 2 to deposit\nEnter 3 to withdraw"
					+ "\nEnter 4 to transfer funds to another account"
					+ "\nEnter 5 to Sign Out";
			
			System.out.println(menu);
			System.out.println();
			while(!sc.hasNextInt()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
			int cases= sc.nextInt();
			
			
			check:
				
			while(true)
			{
			switch (cases)
			{
			case 1:
				
				
				System.out.println("Your Balance is "+cs.viewBalanceById(id));
				System.out.println();
				System.out.println(menu);
				System.out.println();
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				cases= sc.nextInt();
				continue check;
				
			case 2:
				System.out.println("Enter Amount");
				while(!sc.hasNextDouble()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				Double deposit= sc.nextDouble();
				if(deposit>0)
				{
				System.out.println(cs.deposit(deposit, id));
				System.out.println();
				}
				else 
					{System.out.println("Invalid Input");
				System.out.println();
					}
				System.out.println(menu);
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.nextLine();
				}
				cases= sc.nextInt();
				continue check;
					
			case 3: 
				System.out.println("Enter Amount");
				while(!sc.hasNextDouble()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				Double withdraw= sc.nextDouble();
				
				if(withdraw>0 && (es.viewAccount(id).getBalance() - withdraw>=0))
				
				{System.out.println(cs.withdraw(withdraw, id));
				System.out.println();
				}
				else 
					{
					System.out.println("Invalid Input, or not enough balance");
					System.out.println();
					}
				
				System.out.println(menu);
				System.out.println();
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				cases= sc.nextInt();
				continue check;
					
				
			case 4:
				
				System.out.println("Enter the ID of the Account"
						+ " you like to transfer to");
				System.out.println();
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				int toId = sc.nextInt();
				
				System.out.println("Enter Amount");
				while(!sc.hasNextDouble()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				Double amount= sc.nextDouble();
				System.out.println();
				 if( amount>=0 && es.Exist(toId) && (es.viewAccount(id).getBalance() - amount>=0))
				{
				System.out.println(cs.transfer(amount, id, toId));
				System.out.println();
				}
				else
				
				{
					System.out.println("Invalid Input, not not enough balance");
					System.out.println();
				}
				
				
					System.out.println(menu);
					System.out.println();
					while(!sc.hasNextInt()) {
					    System.out.println("Invalid Input, Try Again");
					    sc.next();
					}
					cases= sc.nextInt();
					continue check;
				
			case 5:
				System.out.println("signed out");
				log.error(userName);
				log.error("signed out");
				
				continue maincheck;
				
				
				default:
				System.out.println("Invalid Input");
				System.out.println();
				System.out.println(menu);
				System.out.println();
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				cases= sc.nextInt();
				continue check;

			}
			}
			
			}
		
		else if(ar[0].equalsIgnoreCase(userName) && ar[1].equals(userPass) 
				&& es.viewAccount(userName).getStatus().equals("employee"))
		{
			log.error(userName);
			log.error("signed in");
			
			String menu= " Enter 1 to view all transaction \nEnter 2 to view an account"
					+ "\nEnter 3 to approve pending accounts\nEnter 4 to sign out";
			
			System.out.println(menu);
			System.out.println();
			while(!sc.hasNextInt()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
			int ecases= sc.nextInt();
			int out=0;
			check:
			while(out==0 && ecases <5)
			
			{
				
				switch(ecases)
				{
				case 1:
			System.out.println(es.viewAllTransactions());
			System.out.println(menu);
			System.out.println();
			while(!sc.hasNextInt()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
			ecases= sc.nextInt();
			continue check;
			
				case 2:
					System.out.println("Enter the username");
					System.out.println();
					String user= sc.next();
					
			System.out.println(es.viewAccount(user));
			System.out.println();
			System.out.println(menu);
			System.out.println();
					
			while(!sc.hasNextInt()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
					
			ecases= sc.nextInt();
			continue check;
					
				case 3:
					
					check2:
						while (es.viewPending().size()>0 )
						{
					System.out.println("The following account is pending");
				
					System.out.println(es.viewPending().get(0));
					
					System.out.println("Enter id and then type the "
							+ "new status(costumer, employee, deny)");
					System.out.println();
					while(!sc.hasNextInt()) {
					    System.out.println("Invalid Input, Try Again");
					    sc.next();
					}
					int pendingId= sc.nextInt();
					String decide= sc.next().toLowerCase();
					
					
					
							if (decide.equals("costumer")  && es.viewPending().get(0).getUser_id()==pendingId)
							{
		System.out.println("Application approved, costumer id " + pendingId);
		es.addStatus(decide, pendingId);
							}
								else if (decide.equals("employee")&& es.viewPending().get(0).getUser_id()==pendingId)
								{
									es.addStatus(decide, pendingId);
									System.out.println("Application approved,"
											+ " employee id " + pendingId);
									
								}
								else if (decide.equals("deny") && es.viewPending().get(0).getUser_id()==pendingId)
								{
									es.denyApplication(pendingId);
									System.out.println("Application denied,"
											+ " applicant id " + pendingId);
									
								}

								else
								{
									System.out.println("Invalid Input");
									continue check2;
								}
							
					}
				System.out.println("0 pending accounts ");
				System.out.println();
				System.out.println(menu);
				System.out.println();
				while(!sc.hasNextInt()) {
				    System.out.println("Invalid Input, Try Again");
				    sc.next();
				}
				ecases= sc.nextInt();
				continue check;
				
				case 4:
					System.out.println("signed out");
					log.error(userName);
					log.error("signed out");
					out = 1;
					continue maincheck;
					
					
				}
			
				
			}
			
		}
		
		else
			System.out.println("invalid username or password");
		break;
			}
			else
			{
				System.out.println("invalid username or password.");
			}
			continue maincheck;
			
			
		case 2: 
		
			System.out.println("Enter lastname,firstname, starting balance,"
					+ " username (more than five letters) , passowrd(more than five letters)");
			checkinput:
				while(true)
				{
			String last=sc.next();
			String first=sc.next();
			while(!sc.hasNextDouble()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
			Double balance = sc.nextDouble();
			String user=sc.next().toLowerCase();
			String pass=sc.next();
			if(balance >=0 && balance%1==0 && user.length()>5 && pass.length()>5)
			{
			u= new Costumer(last, first,balance, user, pass);
			cs.applyForAccount(u);
			System.out.println("Thank you, we will proccess your request soon"
					+ "\nEnter 1 to go back to main, or any other number  to exit");
			while(!sc.hasNextInt()) {
			    System.out.println("Invalid Input, Try Again");
			    sc.next();
			}
				int end=sc.nextInt();
				if (end==1)
			{
//				System.out.println("Enter 1 to login\nEnter 2 to apply for an account");
//				hello=sc.nextInt();
				
				continue maincheck;
			}
			else 
			{
				check =0;
			
			break;
			
			}
		}
			else
			{
				
				System.out.println("invalid input, Enter lastname,firstname, "
						+ "starting balance(positive),"
						+ " \nusername (more than five letters) , passowrd"
						+ "(more than five letters)");
				continue checkinput;
			}
			
				}
			
		case 3:
			check = 0;
			System.out.println("Exited.");
			break;
		}
		
	}
		sc.close();
}
}	



		
		
	
	
 
  	   
  	   
  	
 
