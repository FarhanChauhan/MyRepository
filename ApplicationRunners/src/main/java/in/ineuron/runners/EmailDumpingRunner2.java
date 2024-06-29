package in.ineuron.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailDumpingRunner2 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Application runner :: "+Arrays.asList(args.getSourceArgs()));
		System.out.println("Application non optional args :: "+args.getNonOptionArgs());
		
		System.out.println("Application optional args :: "+args.getOptionNames());
		
		for(String optionName : args.getOptionNames()) { 
			System.out.println(optionName+"::"+args.getOptionValues(optionName));
		}
		
		if(args.getNonOptionArgs().contains("start")) {
			System.out.println("Start dumping emails...");
		}
		System.out.println("------------------------------------");
		
	}

}
