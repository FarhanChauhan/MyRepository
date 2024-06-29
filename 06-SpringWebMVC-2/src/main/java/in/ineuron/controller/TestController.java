package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.model.Employee;

@Controller
public class TestController {

	@GetMapping("/register")
	public String showRegister(@ModelAttribute("emp")Employee employee) {
		return "register";
	}
	
	@PostMapping("/register")
	public String showResult(Map<String,Object> model,@ModelAttribute Employee employee) {
		System.out.println(employee);
		model.put("employee", employee);
		return "result";
		
	}
}
