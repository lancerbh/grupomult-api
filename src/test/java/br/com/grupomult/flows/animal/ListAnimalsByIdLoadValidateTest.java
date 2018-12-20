package br.com.grupomult.flows.animal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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
import br.com.grupomult.exceptions.HttpNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ListAnimalsByIdLoadValidateTest {

	@Autowired
	private ListAnimalsByIdLoadValidate flow;

	@MockBean
	private ListAnimalsByIdConverter converter;

	@MockBean
	private Animal entity;

	@MockBean
	private br.com.grupomult.api.animal.models.Animal domain;

	@Before
	public void setUp() throws Exception {
		when(converter.execute(entity)).thenReturn(createResponseEntityResponseGetAnimalsById());
	}

	@Test
	public void testValidateWithAnimalFillSuccess() {
		ResponseEntity<ResponseGetAnimalsById> response = flow.execute(entity);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		ResponseGetAnimalsById body = response.getBody();
		assertNotNull(body);

		br.com.grupomult.api.animal.models.Animal animal = body.getAnimal();
		assertNotNull(animal);
	}

	@Test(expected = HttpNotFoundException.class)
	public void testValidateWithAnimalNullExpectedHttpNotFoundException() {
		flow.execute(null);
	}

	private ResponseEntity<ResponseGetAnimalsById> createResponseEntityResponseGetAnimalsById() {
		ResponseGetAnimalsById response = new ResponseGetAnimalsById();
		response.setAnimal(domain);
		return ResponseEntity.ok(response);
	}

}
