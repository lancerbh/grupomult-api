package br.com.grupomult.flows.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.repositories.AnimalRepository;

public class ListAnimalsByIdLoad {

	@Autowired
	private AnimalRepository repository;

	@Autowired
	private ListAnimalsByIdLoadValidate validate;

	public ResponseEntity<ResponseGetAnimalsById> execute(Integer id) {
		return validate.execute(repository.findOne(id));
	}

}
