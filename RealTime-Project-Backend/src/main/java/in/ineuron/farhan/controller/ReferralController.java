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

import in.ineuron.farhan.model.Referral;
import in.ineuron.farhan.service.IReferralService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ReferralController {

	@Autowired
	private IReferralService service;
	
	@GetMapping("/Referral")
	public List<Referral> getALlReferrals(){
		return service.getAllReferral();
	}
	
	@PostMapping("/Referral")
	public Referral ceateReferrals(@RequestBody Referral Referral){
		return service.saveReferral(Referral);
	}
	
	@GetMapping("/Referral/{id}")
	public ResponseEntity<Referral> getEmplyeeById(@PathVariable Long id){
		Referral Referral = service.getReferralById(id);
		return ResponseEntity.ok(Referral);
	}
	
	@PutMapping("/Referral/{id}")
	public ResponseEntity<Referral> updateReferral(@PathVariable Long id ,@RequestBody Referral Referral){
		Referral Referraldb = service.getReferralById(id);
		Referraldb.setFullName(Referral.getFullName());
	//	Referraldb.setRole(Referral.getRole());
		Referraldb.setEmail(Referral.getEmail());
		Referral updatedReferral = service.saveReferral(Referraldb);
		return ResponseEntity.ok(updatedReferral);
	}
	
	@DeleteMapping("/Referral/{id}")
	public ResponseEntity<?> deleteReferral(@PathVariable Long id) {
		service.deleteReferralById(id);
		HashMap<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
