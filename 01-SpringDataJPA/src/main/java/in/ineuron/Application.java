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
//		
//		CoronaVaccine vaccine = new CoronaVaccine(null,"covidsheild",2,"serum","India",750);
//		System.out.println(service.regusterVaccine(vaccine));
		
//		List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
//		vaccines.add(new CoronaVaccine(null,"sputnik",2,"russie","RUSSIA",350));
//		vaccines.add(new CoronaVaccine(null,"pyzer",3,"pyzwer","USA",650));
//		vaccines.add(new CoronaVaccine(null,"moderena",2,"moderena","USA",560));
//		service.registerInBatch(vaccines);
//		
//		System.out.println(service.checkAvailibilityByRegNo(3));
//		System.out.println(service.getCountVaccines());
//		System.out.println(service.fetchAllRecords());
		
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(5);
//		ids.add(6);
//		Iterable<CoronaVaccine> record = service.fetchAllDetailsById(ids);
//		record.forEach(System.out::println);
//		
//		Optional<CoronaVaccine> optional = service.fetchRecordById(1);
//		if(optional.isPresent())
//			System.out.println(optional.get());
//		optional.orElseThrow(()->
//				new IllegalArgumentException("Record not found "));
	
		//System.out.println(service.deleteById(4));
//		CoronaVaccine vaccine = new CoronaVaccine(4,"pyzer",3,"pyzwer","USA",650);
//		System.out.println(service.removeVaccineObject(vaccine));
		
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(5);
//		ids.add(6);
//		System.out.println(service.removeAllById(ids));
//	
		((ConfigurableApplicationContext) context).close();
	}

}
