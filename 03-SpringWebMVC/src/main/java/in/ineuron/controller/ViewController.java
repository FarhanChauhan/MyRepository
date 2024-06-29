package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/viewDisplay")
	public String display(Model m) {
		m.addAttribute("msg","Welcome to ineuron.ai");
		return "index";
	}
}
