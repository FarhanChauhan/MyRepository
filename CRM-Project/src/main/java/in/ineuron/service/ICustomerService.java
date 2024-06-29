package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Customer;

public interface ICustomerService {

	public List<Customer> getCustomer();
	public Customer saveCustomer(Customer customer);
}
