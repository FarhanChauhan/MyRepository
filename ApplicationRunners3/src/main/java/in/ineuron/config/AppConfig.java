package in.ineuron.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner runA() {
		return new CommandLineRunner() {
			@Override
			public void run(String ...args) {
				System.out.println("Args are :: "+Arrays.asList(args));
			}
		};
	}
}
