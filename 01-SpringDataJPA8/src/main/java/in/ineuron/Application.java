package in.ineuron;

import java.time.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmntService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ICustomerMgmntService service = context.getBean(ICustomerMgmntService.class);
	
		Customer customer = new Customer("dhoni", "CSK", LocalDateTime.of(1988, 7, 7, 15, 0, 12),
				LocalTime.of(12, 00), LocalDate.now());
		String status = service.addCustomer(customer);
		service.fetchAllCustomers().forEach(System.out::println);
		System.out.println(status);
		((ConfigurableApplicationContext) context).close();
	}

}
