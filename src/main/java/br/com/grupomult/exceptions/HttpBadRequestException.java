package br.com.grupomult.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class HttpBadRequestException extends RuntimeException {

	private static final long serialVersionUID = -8161264882801108654L;

	public HttpBadRequestException(String message) {
		super(message);
	}

}
