package in.ineuron;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;
import in.ineuron.model.Product;

public class testApp 
{
    public static void main( String[] args )
    {
    	try {    		
    		ObjectMapper mapper = new ObjectMapper();
    		Product product = new Product();
    		product=getObjectData(product);
			String jsonProduct = mapper.writeValueAsString(product);
			System.out.println(jsonProduct);
			
			mapper.writeValue(new File("product-list.json"), product);
			System.out.println("Wrote the data in file...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private static Product getObjectData(Product product) {
		product.setPid(1);
		product.setPname("fossil");
		product.setPrice(1234.5f);
		product.setTypes(new String[] {"automatic","manual","chronical"});
		return product;
	}
}
