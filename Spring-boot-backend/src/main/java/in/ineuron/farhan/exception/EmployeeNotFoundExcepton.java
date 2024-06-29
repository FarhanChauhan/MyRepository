package in.ineuron.farhan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExcepton extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundExcepton(String message) {
		super(message);
	}

}
