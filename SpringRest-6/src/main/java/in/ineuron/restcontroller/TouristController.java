package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist){
		try {
			String status = service.saveTourist(tourist);
			ResponseEntity<String> entity = new ResponseEntity<String>(status,HttpStatus.OK);
			return entity;
		}catch(Exception e) {
			ResponseEntity<String> entity = new ResponseEntity<String>("Problem while saving the tourist record...",HttpStatus.INTERNAL_SERVER_ERROR);
			return entity;
		}	
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayALLTourist(){
		try {
			List<Tourist> list = service.displayTourists();
			ResponseEntity<List<Tourist>> entity = new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
			return entity;
		}catch(Exception e) {
			ResponseEntity<String> entity = new ResponseEntity<String>("Problem while displaying the tourist records...",HttpStatus.INTERNAL_SERVER_ERROR);
			return entity;
		}
	}
	
	@GetMapping("/displayById/{id}")
	public ResponseEntity<?> displayByIdTourist(@PathVariable Integer id){
		try {
			Tourist tourist = service.displayTouristById(id);
			ResponseEntity<Tourist> entity = new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
			return entity;
		}catch(Exception e) {
			ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			return entity;
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String msg = service.updateTourisr(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/modifyById/{id}/{hike}")
	public ResponseEntity<String> updateTouristById(@PathVariable("id") Integer id,@PathVariable("hike") Float hike){
		try {
			String msg = service.updateTouristById(id,hike);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer id){
		try {
			String msg = service.deleteTouristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
