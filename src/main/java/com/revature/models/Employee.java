package com.revature.models;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private  int transId;
	private Double amount;
	private String user_name;




	public Employee(int transId, Double amount, String user_name) {
		super();
		this.transId = transId;
		this.amount = amount;
		this.user_name = user_name;
		
		
		
	}







	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}







	public int getTransId() {
		return transId;
	}







	public void setTransId(int transId) {
		this.transId = transId;
	}







	public Double getAmount() {
		return amount;
	}







	public void setAmount(Double amount) {
		this.amount = amount;
	}







	public String getUser_name() {
		return user_name;
	}







	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + transId;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		Employee other = (Employee) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (transId != other.transId)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}







	@Override
	public String toString() {
		return "Employee [transId=" + transId + ", amount=" + amount + ", user_name=" + user_name + "]";
	}

	
	
	
}
