package in.ineuron.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig3 {

	@Bean
	public CommandLineRunner runC() {
		return TestConfig::test;
	}
}
