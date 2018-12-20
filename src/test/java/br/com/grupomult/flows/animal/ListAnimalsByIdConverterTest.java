package br.com.grupomult.flows.animal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.grupomult.api.animal.models.Animal.SpeciesEnum;
import br.com.grupomult.api.animal.models.ResponseGetAnimalsById;
import br.com.grupomult.configuration.TestConfiguration;
import br.com.grupomult.converter.AnimalConverter;
import br.com.grupomult.entities.Animal;
import br.com.grupomult.entities.Species;
import br.com.grupomult.flows.animal.ListAnimalsByIdConverter;
import br.com.grupomult.utils.DateUtils;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@PrepareForTest({ AnimalConverter.class, LocalDate.class })
public class ListAnimalsByIdConverterTest {

	private static final LocalDate MOCK_LOCAL_DATE_NOW = LocalDate.of(2016, Month.FEBRUARY, 9);

	private static final String NAME = "Pipoca";
	private static final String DOB = "2015-02-09";
	private static final SpeciesEnum SPECIES = SpeciesEnum.CANINE;
	private static final Long AGE_IN_DAYS = 365l;
	private static final Long AGE_IN_MONTHS = 12l;
	private static final Long AGE_IN_YEARS = 1l;

	@Autowired
	private ListAnimalsByIdConverter flow;

	@Before
	public void setUp() throws Exception {
		mockStatic(LocalDate.class);
		when(LocalDate.now()).thenReturn(MOCK_LOCAL_DATE_NOW);
	}

	@Test
	public void testConvertSuccess() {
		ResponseEntity<ResponseGetAnimalsById> response = flow.execute(createEntityAnimal());
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		ResponseGetAnimalsById body = response.getBody();
		assertNotNull(body);

		br.com.grupomult.api.animal.models.Animal animal = body.getAnimal();
		assertNotNull(animal);
		assertEquals(NAME, animal.getName());
		assertEquals(DOB, animal.getDob());
		assertEquals(SPECIES, animal.getSpecies());
		assertEquals(AGE_IN_DAYS, animal.getAgeInDays());
		assertEquals(AGE_IN_MONTHS, animal.getAgeInMonths());
		assertEquals(AGE_IN_YEARS, animal.getAgeInYears());
	}

	private Animal createEntityAnimal() {
		return Animal.builder().name(NAME).dob(DateUtils.stringToDate(DOB, DateUtils.ISO8601_COMPLETE_DATE))
				.species(Species.builder().code(SPECIES).build()).build();
	}

}
