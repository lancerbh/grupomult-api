package br.com.grupomult.flows.animal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.configuration.TestConfiguration;
import br.com.grupomult.entities.Animal;
import br.com.grupomult.repositories.AnimalRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ListAnimalsByIdLoadTest {

	@Autowired
	private ListAnimalsByIdLoad flow;

	@Autowired
	private AnimalRepository repository;

	@MockBean
	private ListAnimalsByIdLoadValidate validate;

	@MockBean
	private Animal entity;

	@MockBean
	private br.com.grupomult.api.animal.models.Animal domain;

	@Before
	public void setUp() throws Exception {
		when(repository.findOne(anyInt())).thenReturn(entity);
		when(validate.execute(entity)).thenReturn(createResponseEntityResponseGetAnimalsById());
	}

	@Test
	public void testLoadSuccess() {
		ResponseEntity<ResponseGetAnimalsById> response = flow.execute(new Random().nextInt());
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		ResponseGetAnimalsById body = response.getBody();
		assertNotNull(body);

		br.com.grupomult.api.animal.models.Animal animal = body.getAnimal();
		assertNotNull(animal);
	}

	private ResponseEntity<ResponseGetAnimalsById> createResponseEntityResponseGetAnimalsById() {
		ResponseGetAnimalsById response = new ResponseGetAnimalsById();
		response.setAnimal(domain);
		return ResponseEntity.ok(response);
	}

}
