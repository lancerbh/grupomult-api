package br.com.grupomult.flows.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.converter.AnimalConverter;
import br.com.grupomult.entities.Animal;

public class ListAnimalsByIdConverter extends AnimalConverter {

	@Autowired
	private ListAnimalsByIdResponse response;

	public ResponseEntity<ResponseGetAnimalsById> execute(Animal animal) {
		return response.execute(convert(animal));
	}

}
