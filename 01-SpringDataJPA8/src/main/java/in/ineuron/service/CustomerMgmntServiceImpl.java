package in.ineuron.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Customer;
import in.ineuron.dao.IProductDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service(value="service")
public class CustomerMgmntServiceImpl implements ICustomerMgmntService{

	@Autowired
	private IProductDao repo;

	@SuppressWarnings("unchecked")
	@Override
	public String addCustomer(Customer customer) {
		Integer cid =((Customer) repo.save(customer)).getCid();
		return "Customer added with the id : " +cid;
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		List<Customer> list = (List<Customer>) repo.findAll();
		return list;
	}

	
}
