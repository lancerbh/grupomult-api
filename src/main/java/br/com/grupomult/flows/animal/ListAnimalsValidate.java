package br.com.grupomult.flows.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimals;

public class ListAnimalsValidate {

	@Autowired
	private ListAnimalsLoad load;

	public ResponseEntity<ResponseGetAnimals> execute() {
		// Nothing to validate
		return load.execute();
	}

}
