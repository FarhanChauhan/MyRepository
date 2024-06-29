package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController {

	@GetMapping("/viewDisplay")
	public String display(@RequestParam String bookName, @RequestParam String authorName,Model m) {
		String msg = bookName+" is written by the Author "+ authorName;
		m.addAttribute("msg",msg);
		return "index";
	}
	
	@GetMapping("/book/{bname}/{authorName}")
	public String display2(@PathVariable("bname") String bname ,@PathVariable("authorName") String authorName ,Model model) {
		String msg = authorName + " is the Author of the book "+bname + " which is very famous";
		model.addAttribute("msg",msg);
		return "index";
	}
}
