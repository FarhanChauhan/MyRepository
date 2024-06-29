package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/course")
public class CourseController {

	@GetMapping("/{id}/info")
	public ResponseEntity<String> getCourseInfo(@PathVariable Integer id) {
		System.out.println("CourseController.getCourseInfo()");
		System.out.println("id is : "+id);

		String body=null;
		if(id==5) {
			body="haider sir's Spring Batch...";
		}
		else if(id==6) {
			body="NItin Sir's Project Batch....";
		}
		else {
			body="Contact Navin sir....";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(body,HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/{id}/info/JRTP/{name}")
	public ResponseEntity<String> getCourseInfo(@PathVariable Integer id,@PathVariable String name) {
		System.out.println("CourseController.getCourseInfo()");
		System.out.println("id is : "+id);
		
		String body=null;
		if(id==5&&name.equalsIgnoreCase("haider")) {
			body="haider sir's Spring Batch...";
		}
		else if(id==6&&name.equalsIgnoreCase("nitin")) {
			body="NItin Sir's Project Batch....";
		}
		else {
			body="Contact Navin sir....";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(body,HttpStatus.OK);
		return entity;
	}

}
