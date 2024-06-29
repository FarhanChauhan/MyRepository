package in.ineuron.farhan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.farhan.dao.EmployeeRepository;
import in.ineuron.farhan.exception.EmployeeNotFoundExcepton;
import in.ineuron.farhan.model.Employee;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) repo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee getEmplyeeById(Integer id) {
		Employee employee =repo.findById(id).orElseThrow(()-> new EmployeeNotFoundExcepton(
			"Employee does not exists with the id : "+id));
		return employee;
	}
	
	@Override
	public void deleteEmployeeById(Integer id) {

		Employee employee = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundExcepton("Record not exists with the id:: " + id));
		
		repo.delete(employee);
	}
	
}
