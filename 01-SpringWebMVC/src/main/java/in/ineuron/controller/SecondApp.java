package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/second")
public class SecondApp {
	
	@GetMapping("/welcome")
	public ModelAndView displayMsg() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","SecondApplication....");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/java")
	public String GetMapping(Model model) {
		model.addAttribute("message","Second App second message...");
		return "index";
	}
}
