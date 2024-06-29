package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.model.Student;

@Controller
public class StudentController {

	@GetMapping("/studentInfo")
	public String display(Model m) {
		Student std = new Student();
		std.setSid(1);
		std.setFirstName("Farhan");
		std.setLastName("Chauhan");
		std.setCity("Malkapur");
		std.setDob("25/07/2000");
		m.addAttribute("std",std);
		return "student";
	}
}
