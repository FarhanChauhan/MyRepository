package in.ineuron.farhan.service;

import java.util.List;

import in.ineuron.farhan.model.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee employee);
	public Employee getEmplyeeById(Integer id);
	public void deleteEmployeeById(Integer id);
}
