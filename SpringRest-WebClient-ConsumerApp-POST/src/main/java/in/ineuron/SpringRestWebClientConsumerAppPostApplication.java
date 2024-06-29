package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ERailClientApp;

@SpringBootApplication
public class SpringRestWebClientConsumerAppPostApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestWebClientConsumerAppPostApplication.class, args);
		ERailClientApp service = context.getBean(ERailClientApp.class);
		service.invokeRestApi();
	}

}
