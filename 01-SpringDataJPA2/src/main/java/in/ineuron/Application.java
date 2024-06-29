package in.ineuron;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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
		
		//service.sortByPrice(true, "price","name").forEach((vaccine)->System.out.println(vaccine.getPrice()+"===="+vaccine.getName()));
		
		//service.orderInPages(1,3, false, "price","name").forEach(vaccine->System.out.println(vaccine.getName()+"==="+vaccine.getPrice()+"==="+vaccine.getCompany()));
		service.displayAllPages(3);
		((ConfigurableApplicationContext) context).close();
	}

}
