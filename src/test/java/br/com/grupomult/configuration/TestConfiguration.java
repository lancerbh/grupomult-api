package br.com.grupomult.configuration;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import br.com.grupomult.repositories.AnimalRepository;

@Configuration
@ImportResource("classpath:application-context-test.xml")
public class TestConfiguration {

	@MockBean
	private AnimalRepository animalRepository;

}