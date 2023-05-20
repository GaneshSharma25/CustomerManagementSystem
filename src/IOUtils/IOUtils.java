package IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.app.utils.Customer;

public interface IOUtils {
	
	static void storeCustomerDetails(List<Customer> customer, String fileName) throws FileNotFoundException, IOException {
							
				try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){	
					out.writeObject(customer);		
				}
	}
	
	@SuppressWarnings("unchecked")
	static List<Customer> restoreCustomerDetails(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
	
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			
			  return (List<Customer>) in.readObject();
			
		}
	}

}
