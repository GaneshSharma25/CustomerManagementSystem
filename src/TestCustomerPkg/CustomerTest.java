package TestCustomerPkg;
import static IOUtils.IOUtils.*;
import static ValidationRules.CustomerValidationRules.*;
import static ValidationRules.CustomerValidationRules.signInValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.utils.Customer;
import com.app.utils.ServicePlan;

import static com.app.utils.Test.*;

public class CustomerTest {
//C:\Users\dac\Desktop\CustomerDetails.txt
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Customer> customerList = new ArrayList<>();

			boolean exit = false;
			//testData(customerList);
			
			System.out.println("Enter File location ..");
			String fileName = sc.nextLine();
			customerList = restoreCustomerDetails(fileName);
			

			while (!exit) {

				System.out.println("-------------------------------------------------------------------\n"
								 + "Enter Choice..\n"
						         + "1.Sign Up\n"
						         + "2.Sign in\n"
						         + "3.Change password\n"
						         + "4.Unsubscribe Customer\n"
						         + "5.Display all Customer\n"
						         + "6.Sort by email\n"
						         + "7.Sort by dob and registration Amount..\n"
						         + "8.Pay Subsciption\n"
						         + "9.Get all account holder names by Account Type.."
						         + "0.Exit..");
				try {
					
					switch (sc.nextInt()) {
					case 1:
						// sign up
						System.out.println("Enter Customer Details..\n"
								         + "1.FirstName\n"
								         + "2.LastName\n"
								         + "3.Email\n"
								         + "4.Password\n"
								         + "5.DOB (YYYY-MM-DD)\n"
								         + "6.ServicePlan [SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000)]\n"
								         + "7.RegistrationAmount");
						
						customerList.add(newCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), customerList));
						System.out.println("Customer Account created successfully..");
					
						break;
					case 2:
						//sign in
						System.out.println("Enter EmailId and Password.");
						System.out.println(signInValidation(sc.next(),sc.next(),customerList));
						
						break;
					case 3:
						//change password
						System.out.println("Enter emailId and password..");
						Customer newCustomer = signInValidation(sc.next(),sc.next(),customerList);
						System.out.println("Enter New Password..");
						newCustomer.setPassword(sc.next());	
						System.out.println("Password has been changed successfully...");
						break;
					case 4:
					 //Unsubscribe Customer
						System.out.println("Enter emailId and password..");
						 newCustomer = signInValidation(sc.next(),sc.next(),customerList);
						 customerList.remove(newCustomer);
						 System.out.println("Unsubscribed Successfully..");
						break;
					case 5:
						//Display All customer..
						//using for-each loop
//						for (Customer customer : customerList) {
//							System.out.println(customer);
//						}
						
						//using iterator 

						Iterator<Customer> itr = customerList.iterator();
						while(itr.hasNext()) {
							System.out.println(itr.next());
						}

						break;
					case 6:
						//sort by email...//natural sorting ..java.lang.Comparable
						
						Collections.sort(customerList);

						break;
						
					case 7://sort by dob and registration amount..//custom sorting..java.util.Comparator 
						
						Collections.sort(customerList, new Comparator<Customer>() {

							@Override
							public int compare(Customer c1, Customer c2) {
								int res = c1.getDob().compareTo(c2.getDob());
								
								if(res==0) {
									return ((Double)c1.getRegistrationAmount()).compareTo(c2.getRegistrationAmount());
								}
								return res;
							}
							
						});

						break;
						
					case 8://pay subscription..
						 System.out.println("Enter emailId and password..");
						 newCustomer = signInValidation(sc.next(),sc.next(),customerList);
						 
						 System.out.println("Choose a ServicePlan and enter amount\n"
						 		          + "[SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000)]");
						ServicePlan sp = validatePlanAndResgAmount(sc.next(),sc.nextDouble());
						int index = customerList.indexOf(newCustomer);
						customerList.get(index).setServicePlan(sp);
						//customerList.get(index).setRegistrationAmount(sp.getPlanCharge());
						System.out.println("Plan Subscribed Successfully.." +sp);
						break;
						
					case 9:
						//9.Get all account holder names by Account Type..
						
						
						
						break;
					case 0:
						// exit
						System.out.println("Exit..");
						exit = true;
						storeCustomerDetails(customerList,fileName);
						break;

					default:
						System.out.println("Invalid Choice..");
					}

				} catch (Exception e) {
					System.out.println(e);
					e.getStackTrace();
				}

			}
		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();

		}

	}

}
