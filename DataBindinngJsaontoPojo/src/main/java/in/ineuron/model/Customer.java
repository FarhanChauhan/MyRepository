package in.ineuron.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class Customer {

	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;
	private String Company;
	
	//HAS-A
	private Address address;
	
	//Array
	private String[] languages;
	
}
