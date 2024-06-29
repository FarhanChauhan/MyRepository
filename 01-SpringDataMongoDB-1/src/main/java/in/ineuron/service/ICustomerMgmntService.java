package in.ineuron.service;

import java.util.List;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmntService {

	public String registerCustomer(CustomerDTO dto);
	public List<Customer> fetchAllCustomers();
	public String removeCustomer(String id);
	public List<Customer> fetchCustomerByBillAmtRange(Float min,Float max);
	public List<Customer> fetchCustomerNameIn(String name1,String name2);
}
