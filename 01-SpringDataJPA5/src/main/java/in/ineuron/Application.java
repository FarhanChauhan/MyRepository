package in.ineuron;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmntService;
import in.ineuron.type.ResultView;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmntService service = context.getBean(ICoronaVaccineMgmntService.class);

		List<ResultView> list = service.searchVaccineByStartPrice(300);
		list.forEach(vaccine->{
			System.out.println(vaccine.getName()+"  "+vaccine.getCountry());
		});
		
		((ConfigurableApplicationContext) context).close();
	}

}
