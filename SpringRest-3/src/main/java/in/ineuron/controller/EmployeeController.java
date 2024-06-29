package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/report")
	public ResponseEntity<String> getEmployee(@RequestParam(defaultValue="10",required=false) Integer id,@RequestParam(defaultValue="sachin",required=false) String name) {
		System.out.println("EmployeeController.getEmployee()");
		System.out.println("id is : "+id);
		System.out.println("Name is : "+name);
		String body=null;
		if(id==7&&name.equalsIgnoreCase("dhoni")) {
			body="CSK TEAM";
		}
		else if(id==18&&name.equalsIgnoreCase("kohli")) {
			body="RCB TEAM";
		}
		else if(id==10&&name.equalsIgnoreCase("sachin")) {
			body="MI TEAM";
		}
		else {
			body="OTHER TEAM";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(body,HttpStatus.OK);
		return entity;
	}

}