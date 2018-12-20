package br.com.grupomult.api.animal.controllers;

import static br.com.grupomult.constants.ApiConstants.GET_LIST_ANIMALS_BY_ID_PATH_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupomult.api.animal.models.ResponseGetAnimals;
import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.flows.animal.ListAnimalsByIdValidate;
import br.com.grupomult.flows.animal.ListAnimalsValidate;

@RestController
public class AnimalsApiController implements AnimalsApi {

	@Autowired
	private ListAnimalsValidate listAnimalsFlow;

	@Autowired
	private ListAnimalsByIdValidate listAnimalsByIdFlow;

	@Override
	public ResponseEntity<ResponseGetAnimalsById> detail(
			@PathVariable(value = GET_LIST_ANIMALS_BY_ID_PATH_ID, required = true) Integer id) {
		return listAnimalsByIdFlow.execute(id);
	}

	@Override
	public ResponseEntity<ResponseGetAnimals> list() {
		return listAnimalsFlow.execute();
	}

}
