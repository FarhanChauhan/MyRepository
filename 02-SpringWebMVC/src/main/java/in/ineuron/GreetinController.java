package in.ineuron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetinController {

	@GetMapping("/greeting")
	public String greet(Model model) {
		String greet = "All the best for jobs";
		model.addAttribute("text",greet);
		return "index";
	}
}
