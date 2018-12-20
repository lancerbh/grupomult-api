package br.com.grupomult.flows.animal;

import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.Animal;
import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;

public class ListAnimalsByIdResponse {

	public ResponseEntity<ResponseGetAnimalsById> execute(Animal animal) {
		return ResponseEntity.ok(new ResponseGetAnimalsById().animal(animal));
	}

}
