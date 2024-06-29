package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.ICustomerRepo;
import in.ineuron.model.Customer;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerRepo repo;
	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

}
