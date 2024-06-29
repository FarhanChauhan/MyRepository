package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmntService;
import jakarta.persistence.EntityNotFoundException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmntService service = context.getBean(ICoronaVaccineMgmntService.class);
//		CoronaVaccine vaccine = new CoronaVaccine();
//		vaccine.setPrice(560);
//		List<CoronaVaccine> list = service.getVaccineyDetail(vaccine, false, "price");
//		list.forEach(System.out::println);
		
//		try {
//			CoronaVaccine vaccine = service.getVaccineById(10);
//			System.out.println(vaccine);	
//		}catch(EntityNotFoundException ee) {
//			System.out.println("No Records found ");
//		}catch(Exception e) {
//			System.out.println("No Records found ");
//		}
//		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		service.removeAllbyRegNo(ids);
		
		((ConfigurableApplicationContext) context).close();
	}

}
