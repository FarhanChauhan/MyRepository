package in.ineuron.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ineuron.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String>{
	
	public List<Customer> findByBillAmtBetween(Float min,Float max);
	public List<Customer> findByCnameInAndBillAmtNotNull(String name1,String mame2);

}
