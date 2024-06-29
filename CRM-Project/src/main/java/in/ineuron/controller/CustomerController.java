package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String getCustomerList(Map<String,Object> model) {
		
		List<Customer> customers = service.getCustomer();
		model.put("customers",customers);
		return "list-customer";
	}
	
	@GetMapping("showForm")
	public String showForm(Map<String,Object>map) {
		Customer customer = new Customer();
		map.put("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
}
