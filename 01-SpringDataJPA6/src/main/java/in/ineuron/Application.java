package in.ineuron;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmntService;
import in.ineuron.type.ResultView1;
import in.ineuron.type.ResultView2;
import in.ineuron.type.ResultView3;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmntService service = context.getBean(ICoronaVaccineMgmntService.class);

		service.searchVaccineByCompany("sputnik",ResultView1.class).forEach(vaccine->{
			System.out.println(vaccine.getName()+" "+vaccine.getCompany());
		});
		
		System.out.println();
		
		service.searchVaccineByCompany("sputnik",ResultView2.class).forEach(vaccine->{
			System.out.println(vaccine.getRegNo()+" "+vaccine.getCountry()+" "+vaccine.getPrice());
		});
		
		System.out.println();
		
		service.searchVaccineByCompany("sputnik",ResultView3.class).forEach(vaccine->{
			System.out.println(vaccine.getName()+" "+vaccine.getCompany()+" "+vaccine.getPrice());
		});
		
		((ConfigurableApplicationContext) context).close();
	}

}
