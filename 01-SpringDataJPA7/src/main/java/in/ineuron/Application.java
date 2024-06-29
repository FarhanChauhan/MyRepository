package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IProductMgmntService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		//System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		IProductMgmntService service = context.getBean(IProductMgmntService.class);
		service.fetchProductByName("fossil","oil").forEach(System.out::println);;
		((ConfigurableApplicationContext) context).close();
	}

}
