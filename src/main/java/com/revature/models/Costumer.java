package com.revature.models;

import java.io.Serializable;

public class Costumer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String lastName;
	private String firstName;
	private double balance;
	private String user_name;
	private String user_pass;
	private String status;
	private Costumer costumer;

	




	public Costumer() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Costumer(int user_id, String lastName, String firstName, double balance, String user_name, String user_pass, String status) {
		super();
		this.user_id = user_id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.status = status;
	}





	public Costumer(String lastName, String firstName, double balance, String user_name, String user_pass) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
		this.user_name = user_name;
		this.user_pass = user_pass;
		
	}
	
	
	public Costumer( String lastName, String firstName, double balance, String user_name, String user_pass, String status) {
		super();
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.status = status;
	}

//	public void clear()
//	{
//		user_id=0;
//		lastName=null;
//		firstName=null;
//		 balance=0;
//		user_name=null;
//		user_pass=null;
//		costumer=null;
//	}





	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getFirstName() {
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public double getBalance() {
		return balance;
	}





	public void setBalance(double balance) {
		this.balance = balance;
	}





	public String getUser_name() {
		return user_name;
	}





	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}





	public String getUser_pass() {
		return user_pass;
	}





	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public Costumer getUsers() {
		return costumer;
	}





	public void setUsers(Costumer costumer) {
		this.costumer = costumer;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
		result = prime * result + ((costumer == null) ? 0 : costumer.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_pass == null) {
			if (other.user_pass != null)
				return false;
		} else if (!user_pass.equals(other.user_pass))
			return false;
		if (costumer == null) {
			if (other.costumer != null)
				return false;
		} else if (!costumer.equals(other.costumer))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Costumer [user_id=" + user_id + ", lastName=" + lastName + ", firstName=" + firstName + ", balance="
				+ balance + ", user_name=" + user_name + ", user_pass=" + user_pass + ", status=" + status + "]";
	}


	
	
}