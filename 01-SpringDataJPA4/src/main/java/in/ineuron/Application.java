package in.ineuron;


import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmntService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmntService service = context.getBean(ICoronaVaccineMgmntService.class);

		ArrayList<String> company = new ArrayList<String>();
		company.add("patanjali");
		company.add("sputnik");
		
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("IND");
		countries.add("USA");
		
	//	service.fetchVaccineByCompany("patanjali").forEach(System.out::println);;
		service.fetchByCompanyInAndPriceBetween(company, 300, 500).forEach(System.out::println);
		service.fetchSByCountryNotIn(countries).forEach(System.out::println);
		service.fetchByPriceLessThan(400).forEach(System.out::println);
		
		((ConfigurableApplicationContext) context).close();
	}

}
