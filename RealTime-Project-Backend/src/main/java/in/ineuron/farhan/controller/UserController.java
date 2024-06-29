package in.ineuron.farhan.controller;

import java.util.HashMap;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.farhan.model.User;
import in.ineuron.farhan.service.IUserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/user")
	public List<User> getALlUsers(){
		System.out.println(service.generateReferralCode());
		return service.getAllUser();
	}
	
	@PostMapping("/user")
	public User ceateUsers(@RequestBody User User){
		return service.saveUser(User);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getEmplyeeById(@PathVariable Long id){
		User User = service.getUserById(id);
		return ResponseEntity.ok(User);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id ,@RequestBody User User){
		User userdb = service.getUserById(id);
		userdb.setFullName(User.getFullName());
		userdb.setRole(User.getRole());
		userdb.setEmail(User.getEmail());
		User updatedUser = service.saveUser(userdb);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		service.deleteUserById(id);
		HashMap<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
