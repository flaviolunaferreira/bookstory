package the.coyote.bookstory.resource;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import the.coyote.bookstory.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
