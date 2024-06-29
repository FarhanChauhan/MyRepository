package in.ineuron.runners;

import java.util.Arrays;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailDumpingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Comman lineArguments are :  "+Arrays.asList(args));

	}

}
