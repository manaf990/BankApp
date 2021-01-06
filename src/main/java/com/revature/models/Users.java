package com.revature.models;

import java.io.Serializable;

public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String lastName;
	private String firstName;
	private double balance;
	private String user_name;
	private String user_pass;
	private Users users;

	




	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Users(int user_id, String lastName, String firstName, double balance, String user_name, String user_pass) {
		super();
		this.user_id = user_id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
		this.user_name = user_name;
		this.user_pass = user_pass;
	}





	public Users(String lastName, String firstName, double balance, String user_name, String user_pass) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
		this.user_name = user_name;
		this.user_pass = user_pass;
	}

	public void clear()
	{
		user_id=0;
		lastName=null;
		firstName=null;
		 balance=0;
		user_name=null;
		user_pass=null;
		users=null;
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
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Users other = (Users) obj;
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}





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





	public Users getUsers() {
		return users;
	}





	public void setUsers(Users users) {
		this.users = users;
	}





	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", lastName=" + lastName + ", firstName=" + firstName + ", balance="
				+ balance + ", user_name=" + user_name + ", user_pass=" + user_pass + "]";
	}
	
	
	
}