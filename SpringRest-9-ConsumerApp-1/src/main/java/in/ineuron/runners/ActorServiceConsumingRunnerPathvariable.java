package in.ineuron.runners;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunnerPathvariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_pathVariable.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:8080/api/actor/wish/{id}/{name}";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 7);
		map.put("name", "dhoni");
		ResponseEntity<String> responseEntity = template.getForEntity(serviceUrl, String.class, map);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().toString());
		System.out.println("********************************************************");


	}
}