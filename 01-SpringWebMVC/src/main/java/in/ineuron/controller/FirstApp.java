package in.ineuron.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/first")
public class FirstApp {
	
	static Logger logger = Logger.getLogger(FirstApp.class);
	static {
		PropertyConfigurator.configure("src/main/java/in/ineuron/cfg/log4j.properties");
	}
	
	@RequestMapping("/welcome")
	public ModelAndView displayMsg() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","FirstApplication!...");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/java")
	public String display(Model model) {
		logger.info("display Method called ...");
		model.addAttribute("message","spring boot is awesome!...");
		return "index";
	}
	
	@GetMapping("/wishing")
	public void getNmae(Map<String,Object> model) {
		logger.info("GetName Method called ...");
		model.put("message","Farhan Chauhan");
		return;
	}

	@GetMapping("/wish2")
	public String getNmae(HttpServletResponse response) throws IOException {
		logger.info("GetName Method called ...");
		PrintWriter out = response.getWriter();
		out.println("Hello Farhan");
		return null;
	}
	@GetMapping("/wish")
	public Map<String,Object> getNmae(){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message", "Farhan Chauhan");
		return map;
	}
	
	@PostMapping
	public String getAddress(Model model) {
		logger.info("GetAddress Method called ...");
		model.addAttribute("message","Weekly Market Malkpaur");
		return "index";
	}
}
