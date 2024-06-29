package in.ineuron.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailDumpingRunner implements CommandLineRunner {

	//overriding value of application.properties
	@Value("server.port")
	private Integer port ;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Comman lineArguments are :  "+Arrays.asList(args));

	}

}
