package br.com.grupomult.flows.animal;

import static br.com.grupomult.utils.OptionalUtils.ofNullableAndEmpty;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.grupomult.api.animal.models.Animal;
import br.com.grupomult.api.animal.models.ResponseGetAnimals;
import br.com.grupomult.converter.AnimalConverter;

public class ListAnimalsConverter extends AnimalConverter {

	@Autowired
	private ListAnimalsResponse response;

	public ResponseEntity<ResponseGetAnimals> execute(List<br.com.grupomult.entities.Animal> animals) {

		/*
		 * Se a consulta do banco retornar uma lista nula ou vazia apenas é criada uma
		 * lista vazia do tipo de resposta da API, caso contrário é gerada uma lista com
		 * objetos de resposta da API baseados nos objetos do banco.
		 */
		List<Animal> animalsApi = ofNullableAndEmpty(animals).orElse(Collections.emptyList()).stream()
				.map(ListAnimalsConverter::convert).collect(Collectors.toList());

		return response.execute(animalsApi);

	}

}
