package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

	@GetMapping("/")
	public String welcomeMsg() {
		return "WELCOME TO ICICI BANK";
	}
	@GetMapping("/transfer")
	public String fundTransfer() {
		return "Transfer is inisialised.....";
	}
	@GetMapping("/about")
	public String aboutUs() {
		return "ICICI BANK is maintained by the govt. of INDIA";
	}
	@GetMapping("/balance")
	public String checkBalance() {
		return "The balance is : 100000INR";
	}
}
