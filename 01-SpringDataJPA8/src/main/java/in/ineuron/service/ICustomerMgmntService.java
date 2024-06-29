package in.ineuron.service;

import java.util.List;
import in.ineuron.bo.Customer;

public interface ICustomerMgmntService {

	public String addCustomer(Customer customer);
	public List<Customer> fetchAllCustomers();

}
