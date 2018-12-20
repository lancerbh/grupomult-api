package br.com.grupomult.flows.animal;

import static br.com.grupomult.constants.MessageConstants.ERROR_GET_ANIMALS_BY_ID_INVALID_ID;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.exceptions.HttpBadRequestException;

public class ListAnimalsByIdValidate {

	@Autowired
	private ListAnimalsByIdLoad load;

	public ResponseEntity<ResponseGetAnimalsById> execute(Integer id) {
		if (!Optional.ofNullable(id).isPresent() || id < 0) {
			throw new HttpBadRequestException(ERROR_GET_ANIMALS_BY_ID_INVALID_ID);
		}
		return load.execute(id);
	}

}
