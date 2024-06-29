package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceController {

	@Autowired
	private IStockPriceService service;
	
	@GetMapping("stockPrice/{companyName}")
	public ResponseEntity<Double> getCompanyByPrice(@PathVariable String companyName) {
		Double companyPrice = service.getByCompanyName(companyName);
		System.out.println(companyName + " : "+ companyPrice);
		return new ResponseEntity<Double>(companyPrice,HttpStatus.OK);
	}
}
