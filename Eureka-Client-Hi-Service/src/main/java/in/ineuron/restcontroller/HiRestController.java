package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.HelloClient;

@RestController
public class HiRestController {

	@Autowired
	private HelloClient client;
	
	@GetMapping("/hi/{name}")
	public String greet(@PathVariable String name) {
		return name + " hiee how are u ?" +client.invokeFeignClient(name);
	}
}
