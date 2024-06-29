package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	public String saveEmployee() {
		System.out.println("Employee object is saved..");
		
//		if(new Random().nextInt(15)<10){
//			throw new RuntimeException("Dummy Exception");
//		}
		
		return "The object is saved with the id : 5";
	}
	

}
