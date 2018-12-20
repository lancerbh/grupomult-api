package br.com.grupomult.flows.animal;

import static br.com.grupomult.constants.MessageConstants.ERROR_GET_ANIMALS_BY_ID_NOT_FOUND;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.entities.Animal;
import br.com.grupomult.exceptions.HttpNotFoundException;

public class ListAnimalsByIdLoadValidate {

	@Autowired
	private ListAnimalsByIdConverter converter;

	public ResponseEntity<ResponseGetAnimalsById> execute(Animal animal) {
		if (Optional.ofNullable(animal).isPresent()) {
			return converter.execute(animal);
		} else {
			throw new HttpNotFoundException(ERROR_GET_ANIMALS_BY_ID_NOT_FOUND);
		}
	}

}
