package ValidationRules;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.utils.Customer;
import com.app.utils.ServicePlan;

import CustomException.CustomerHandlingException;

public class CustomerValidationRules {

	//Single point calling method...packaging all validation in one method ..
	public static Customer newCustomer(String firstName, String lastName, String email, String password, String dob,
			String servicePlan, double registrationAmount, List<Customer> customer)
			throws CustomerHandlingException {
		validateDuplicateCustomer(email, customer);
		LocalDate validDob = validateCustomerAge(dob);
		ServicePlan validPlan = validatePlanAndResgAmount(servicePlan,registrationAmount);
		return new Customer(firstName,lastName,email,password,validDob,validPlan,registrationAmount);
	}

	// Validate duplicate Customer...PK emailId
	public static void validateDuplicateCustomer(String email, List<Customer> newCustomer)
			throws CustomerHandlingException {
		Customer custTemp = new Customer(email);
		if (newCustomer.contains(custTemp)) {
			throw new CustomerHandlingException("Email already exists try different email..");
		}
	}

	// validate Customer age.. age condition-- minimum age should be 21 years..
	public static LocalDate validateCustomerAge(String dob) throws CustomerHandlingException {
		LocalDate custDob = LocalDate.parse(dob);
		LocalDate today = LocalDate.now();
		int age = Period.between(custDob, today).getYears();
		if (age < 21) {
			throw new CustomerHandlingException("Invalid Age , Minimum age should be 21 years..");
		}
		return custDob;
	}

	// validate plan and registration amount...
	public static ServicePlan validatePlanAndResgAmount(String servicePlan, double amount)
			throws CustomerHandlingException {

		if (ServicePlan.valueOf(servicePlan.toUpperCase()).getPlanCharge() != amount) {
			throw new CustomerHandlingException("Invalid Registration amount..");
		}
		return ServicePlan.valueOf(servicePlan.toUpperCase());
	}
	
	//sign validation method..
	public static Customer signInValidation(String email,String password, List<Customer> customer) throws CustomerHandlingException {
		Customer newCustomer = new Customer(email);	
		int index = customer.indexOf(newCustomer);
		if(index == -1) {
			throw new CustomerHandlingException("Invalid Email..");	
		}
		if(customer.get(index).getPassword().equals(password)) {
			return customer.get(index);	
		}
		throw new CustomerHandlingException("Invalid Password..");
		
	}

}
