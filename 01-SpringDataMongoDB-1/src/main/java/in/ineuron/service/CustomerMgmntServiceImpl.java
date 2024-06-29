package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;

@Service("service")
public class CustomerMgmntServiceImpl implements ICustomerMgmntService{

	@Autowired
	private ICustomerRepo repo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		Customer document = new Customer();
		BeanUtils.copyProperties(dto, document);
		document.setId(IdGenerator.generateId());
		document = repo.save(document);	
		return "Document inserted with id : "+document.getId();
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return repo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
		Optional<Customer> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Document deleted successfully with id : "+id;
		}
		else {
			return "document not found ";
		}
	}

	@Override
	public List<Customer> fetchCustomerByBillAmtRange(Float min, Float max) {
		return repo.findByBillAmtBetween(min, max);
	}

	@Override
	public List<Customer> fetchCustomerNameIn(String name1, String name2) {
		return repo. findByCnameInAndBillAmtNotNull(name1, name2);
	}

	
}
