package in.ineuron.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer regNo;
	private String name;
	private Integer requiredDoseCount;
	private String country;
	private String company;
	private Integer price;
	
	public CoronaVaccine() {
		
	}
	public CoronaVaccine(Integer regNo, String name, Integer requiredDoseCount, String country, String company,
			Integer price) {
		this.regNo = regNo;
		this.name = name;
		this.requiredDoseCount = requiredDoseCount;
		this.country = country;
		this.company = company;
		this.price = price;
	}
	public CoronaVaccine(String company, String country, String name, Integer price,Integer requiredDoseCount) {
		this.name = name;
		this.requiredDoseCount = requiredDoseCount;
		this.country = country;
		this.company = company;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CoronaVaccine [regNo=" + regNo + ", name=" + name + ", requiredDoseCount=" + requiredDoseCount
				+ ", country=" + country + ", company=" + company + ", price=" + price + "]";
	}
	public Integer getRegNo() {
		return regNo;
	}
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRequiredDoseCount() {
		return requiredDoseCount;
	}
	public void setRequiredDoseCount(Integer requiredDoseCount) {
		this.requiredDoseCount = requiredDoseCount;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
