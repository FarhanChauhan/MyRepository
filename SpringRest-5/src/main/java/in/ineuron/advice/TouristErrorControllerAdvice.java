package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException te) {
		
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),te.getMessage(),"404-Error Nor Found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllOther(Exception e){
		
		System.out.println("TouristErrorControllerAdvice.handleAllOther()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in execution...");	
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
