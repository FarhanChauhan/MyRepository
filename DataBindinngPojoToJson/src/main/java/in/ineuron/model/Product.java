package in.ineuron.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class Product
{
	private Integer pid;
	private String pname;
	private Float price;
	private String[] types;

}
