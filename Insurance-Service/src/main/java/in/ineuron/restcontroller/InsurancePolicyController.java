package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IPolicyService;
import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/api/name")
public class InsurancePolicyController {

	@Autowired
	private IPolicyService service;
	
	@GetMapping("policy/{policyId}")
	public ResponseEntity<String> getPolicyById(@PathVariable Integer policyId) {
		String policyName = service.getPolicyById(policyId);
		return new ResponseEntity<String>(policyName,HttpStatus.OK);
	}
}
