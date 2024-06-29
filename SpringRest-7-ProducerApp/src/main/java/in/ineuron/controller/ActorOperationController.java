package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor")
public class ActorOperationController {
	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage() {

		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		String user = "sachin";

		String body = null;
		if (hour < 12)
			body = "Good Morning:: " + user;
		else if (hour < 16)
			body = "Good Afternoon :: " + user;
		else if (hour < 20)
			body = "Good Evening:: " + user;
		else
			body = "Good Night:: " + user;

		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {

		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();

		String body = null;
		if (hour < 12)
			body = "Good Morning:: " + name + " Assoaciated id is :: " + id;
		else if (hour < 16)
			body = "Good Afternoon :: " + name + " Assoaciated id is :: " + id;
		else if (hour < 20)
			body = "Good Evening:: " + name + " Assoaciated id is :: " + id;
		else
			body = "Good Night:: " + name + " Assoaciated id is :: " + id;

		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> displayWishMessage(@RequestBody Actor actor) {
		return new ResponseEntity<String>("The actor data is : " +actor.toString(), HttpStatus.CREATED);
	}
	@GetMapping("/register/{id}")
	public ResponseEntity<Actor> displayWishMessage(@PathVariable Integer id) {
		return new ResponseEntity<Actor>(new Actor(id,"dhoni",44.0f,"captain"), HttpStatus.OK);
	}
}
	
