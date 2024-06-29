package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmntService;

@SpringBootApplication
public class DaoSpringDataJpaMongoDbCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DaoSpringDataJpaMongoDbCrudAppApplication.class);
		ICustomerMgmntService service = context.getBean(ICustomerMgmntService.class);
//		String status = service.registerCustomer(new CustomerDTO(36,"yuvi",170.0f));
//		System.out.println(status);
//		String removeStatus = service.removeCustomer("65d81755bbea0f0ad663a6aa");
//		System.out.println(removeStatus);
//		service.fetchAllCustomers().forEach(System.out::println);

//		service.fetchCustomerByBillAmtRange(100.0f,250.0f).forEach(System.out::println);
		service.fetchCustomerNameIn("virat","dhoni").forEach(System.out::println);
		((ConfigurableApplicationContext) context).close();
	}

}
