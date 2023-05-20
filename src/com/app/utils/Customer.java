package com.app.utils;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Customer implements Comparable<Customer>,Serializable {
	
	private int custId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate lastSubscriptionPaidDate;
	private LocalDate dob;
	private ServicePlan servicePlan;
	private static int idGenerator;
	
	
	static {
		idGenerator = 100;
	}
	
	public Customer(String firstName, String lastName, String email, String password,
			LocalDate dob, ServicePlan servicePlan, double registrationAmount) {
		super();
		this.custId = custId + idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.servicePlan = servicePlan;
		this.registrationAmount = registrationAmount;
		this.lastSubscriptionPaidDate = LocalDate.now();
		idGenerator++;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}
	
	public Customer(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob
				+ ", servicePlan= " + servicePlan + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Customer) {
			return this.email.equals(((Customer)o).email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Customer customer) {	
		return this.email.compareTo(customer.email);
	}

	//---------------------------------------------------------------------------------------------------
	//Setter Getters...

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getRegistrationAmount() {
		return registrationAmount;
	}


	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public ServicePlan getServicePlan() {
		return servicePlan;
	}


	public void setServicePlan(ServicePlan servicePlan) {
		this.servicePlan = servicePlan;
	}


	public int getCustId() {
		return custId;
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	
	

	
	

}
