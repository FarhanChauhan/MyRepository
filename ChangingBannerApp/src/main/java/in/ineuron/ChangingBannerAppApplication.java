package in.ineuron;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChangingBannerAppApplication {

	public static void main(String[] args) {
		
		//SpringApplication application = new SpringApplication();
		//application.setBannerMode(Mode.CONSOLE);
		ApplicationContext applicationContext = SpringApplication.run(ChangingBannerAppApplication.class, args);
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
