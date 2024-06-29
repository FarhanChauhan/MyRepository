package in.ineuron.runners;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Actor;

@Component
public class ActorServiceConsumingRunner_GetJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_GetJsonData.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:8080/api/actor/register/{id}";
		
		Map<String, Object> map = Map.of("id",7);

		ResponseEntity<Actor> responseEntity = template.getForEntity(serviceUrl, Actor.class,map);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().toString());
		System.out.println("********************************************************");

	}
}
