package br.com.grupomult.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public final class HttpNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8500278227911456367L;

	public HttpNotFoundException(String message) {
		super(message);
	}

}
