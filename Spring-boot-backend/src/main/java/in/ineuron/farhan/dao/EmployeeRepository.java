package in.ineuron.farhan.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.farhan.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
