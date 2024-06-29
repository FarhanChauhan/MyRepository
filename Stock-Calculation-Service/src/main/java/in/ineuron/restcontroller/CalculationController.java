package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.StockClient;

@RestController
@RequestMapping("/calc")
public class CalculationController {
	
	@Autowired
	private StockClient client;

	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculateStockPrice(@PathVariable String companyName,@PathVariable Integer quantity){
		
		ResponseEntity<?> responseEntity = null;
		
		try {
			responseEntity = client.getStockPrice(companyName);
			if(responseEntity.getStatusCode().value()==200) {
				Double stockPrice = (Double) responseEntity.getBody();	
				double totalPrice = stockPrice * quantity;
				String response = "The total Cost is :: "+totalPrice;
				responseEntity = new ResponseEntity<String>(response,HttpStatus.OK);
			}
		}catch(Exception e) {
			responseEntity = new ResponseEntity<String>("Company not available...",HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
}
