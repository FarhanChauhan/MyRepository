package in.ineuron.service;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class ERailClientApp {

	private String REST_API_CALL="http://localhost:8080/api/ticket/register";

	public void invokeRestApi() {
		
		WebClient webClient = WebClient.create();
		
		PassengerInfo body = new PassengerInfo();
		body.setFirstName("nitin");
		body.setLastName("manjunath");
		body.setJourneyDate("22/06/2023");
		body.setFrom("bengaluru");
		body.setTo("pune");
		body.setTrainNumber("BNG-PUN-1234");
		
		Ticket response = webClient.post().
				uri(REST_API_CALL).
				accept(MediaType.APPLICATION_JSON).
				body(BodyInserters.fromValue(body))
				.retrieve().bodyToMono(Ticket.class).block();
				System.out.println(response);
	}
}
