package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

	@GetMapping("/course")
	public String display(Model m) {
		m.addAttribute("cid","123abc");
		m.addAttribute("cname","java");
		m.addAttribute("cost","17,700 INR");
		return "course";
	}
}
