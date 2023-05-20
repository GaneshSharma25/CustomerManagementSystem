package com.app.utils;

import java.util.List;

import CustomException.CustomerHandlingException;

import static ValidationRules.CustomerValidationRules.*;

public class Test {

	public static void testData(List<Customer> customer) throws CustomerHandlingException {
		customer.add(newCustomer("ganesh","sharma","ganesh@gmail.com","abc123","2000-05-20","Platinum",10000,customer));
		customer.add(newCustomer("Sam","heckker","sam@gmail.com","abc123","1991-01-20","gold",2000,customer));
		customer.add(newCustomer("piyush","mishra","piyush@gmail.com","abc123","1997-05-20","Silver",1000,customer));
		customer.add(newCustomer("joe","biden","joe@gmail.com","abc123","2000-05-20","Diamond",5000,customer));
		customer.add(newCustomer("Hilary","clinton","hilary@gmail.com","abc123","1965-07-20","Platinum",10000,customer));
		
	}
	
}
