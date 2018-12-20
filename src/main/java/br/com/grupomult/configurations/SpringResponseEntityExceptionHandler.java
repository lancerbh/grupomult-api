package br.com.grupomult.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.grupomult.exceptions.HttpBadRequestException;
import br.com.grupomult.exceptions.HttpNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ControllerAdvice
public class SpringResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if (ex instanceof HttpBadRequestException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof HttpNotFoundException) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(createError(status, ex), status);
	}

	private static final Error createError(HttpStatus status, Exception ex) {
		return new Error(status.value(), ex.getMessage());
	}

	@Getter
	@AllArgsConstructor
	private static final class Error {
		private final int status;
		private final String message;
	}

}
