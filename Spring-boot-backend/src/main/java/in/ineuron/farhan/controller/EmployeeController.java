package in.ineuron.farhan.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.farhan.model.Employee;
import in.ineuron.farhan.service.IEmployeeService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee> getALlEmployees(){
		System.out.println(LocalDateTime.now());
		return service.getAllEmployee();
	}
	
	@PostMapping("/employee")
	public Employee ceateEmployees(@RequestBody Employee employee){
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmplyeeById(@PathVariable Integer id){
		Employee employee = service.getEmplyeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id ,@RequestBody Employee employee){
		Employee empdb = service.getEmplyeeById(id);
		empdb.setFirstName(employee.getFirstName());
		empdb.setLastName(employee.getLastName());
		empdb.setEmail(employee.getEmail());
		Employee updatedEmployee = service.saveEmployee(empdb);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployeeById(id);
		HashMap<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
