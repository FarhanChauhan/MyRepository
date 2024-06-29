package in.ineuron;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

public class testApp 
{
    public static void main( String[] args )
    {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		//Customer customer = mapper.readValue(new File("data/sample-lite.json"), Customer.class);
			Customer customer = mapper.readValue(new File("data/sample-full.json"), Customer.class);
			System.out.println(customer);
			
			System.out.println(customer.getFirstName());
			System.out.println(customer.getLastName());
			System.out.println(customer.getActive());
			
			//object
			System.out.println(customer.getAddress());
			
			//array
			for(String language:customer.getLanguages()){
				System.out.println(language);
			}
			
			System.out.println(customer.getCompany());
			
    	} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
