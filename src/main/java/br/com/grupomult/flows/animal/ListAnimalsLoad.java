package br.com.grupomult.flows.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.ResponseGetAnimals;
import br.com.grupomult.entities.Animal;
import br.com.grupomult.repositories.AnimalRepository;

public class ListAnimalsLoad {

	@Autowired
	private AnimalRepository repository;

	@Autowired
	private ListAnimalsConverter converter;

	public ResponseEntity<ResponseGetAnimals> execute() {
		return converter.execute((List<Animal>) repository.findAll());
	}

}
