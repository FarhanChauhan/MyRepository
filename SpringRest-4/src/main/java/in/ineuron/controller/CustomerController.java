package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Company;
import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {

		System.out.println("The id of the customer is : "+id);
		Customer customer = new Customer();
		customer.setCno(id);
		customer.setCname("Sachin");
		customer.setBillAmount(54.3f);
		customer.setCompany(new Company("MI","IPL","Mumbai",45));
		customer.setIdDetails(Map.of("aadharNo",2774448449l,"panNo","BZQ83292"));
		customer.setPhoneNumbers(Set.of(9997772222l,8888777444l,9675551124l));
		customer.setStudies(List.of("10th","12th","Engineering"));
		customer.setTeamNames(new String[] {"MI","india","AsiaXI","Mumbai"});
		
		
		ResponseEntity<Customer> entity = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody Customer customer) {
		
		System.out.println(customer);
		return "Cutomer saved with the id : "+customer.getCno();
	}

}
