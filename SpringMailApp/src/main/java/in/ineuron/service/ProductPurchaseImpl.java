package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("service")
public class ProductPurchaseImpl implements IProductPurchase {

	@Autowired
	private JavaMailSender sender;
	
	@Value("spring.mail.username")
	private String toEmail;
	
	
	
	@Override
	public String doShopping(String[] items, Double[] prices, String[] toEmails) {
		
	
		
		return null;
	}

}
