package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.CurrencyService;

@SpringBootApplication
public class SpringRestWebClientConsumerAppGetApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestWebClientConsumerAppGetApplication.class, args);
		CurrencyService service = context.getBean(CurrencyService.class);
		String from = "USD";
		String to ="INR";
		service.invokeRestApiSync(from,to);
		System.out.println("++++++++++++++++++++++");
		service.invokeRestApiASync(from, to);
	}

}
