package br.com.grupomult.flowdefinitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.grupomult.configuration.TestConfiguration;
import br.com.grupomult.flows.animal.ListAnimalsByIdConverter;
import br.com.grupomult.flows.animal.ListAnimalsByIdLoad;
import br.com.grupomult.flows.animal.ListAnimalsByIdLoadValidate;
import br.com.grupomult.flows.animal.ListAnimalsByIdResponse;
import br.com.grupomult.flows.animal.ListAnimalsByIdValidate;
import br.com.grupomult.flows.animal.ListAnimalsConverter;
import br.com.grupomult.flows.animal.ListAnimalsLoad;
import br.com.grupomult.flows.animal.ListAnimalsResponse;
import br.com.grupomult.flows.animal.ListAnimalsValidate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class FlowDefinitionTest {

	@Autowired
	private ApplicationContext applicationContest;

	@Test
	public void testFlowListAnimalsExistsSuccess() {
		assertNotNull(applicationContest.getBean("listAnimalsValidate"));
		assertNotNull(applicationContest.getBean("listAnimalsLoad"));
		assertNotNull(applicationContest.getBean("listAnimalsConverter"));
		assertNotNull(applicationContest.getBean("listAnimalsResponse"));
	}

	@Test
	public void testFlowListAnimalsInstanceofSuccess() {
		assertTrue(applicationContest.getBean("listAnimalsValidate") instanceof ListAnimalsValidate);
		assertTrue(applicationContest.getBean("listAnimalsLoad") instanceof ListAnimalsLoad);
		assertTrue(applicationContest.getBean("listAnimalsConverter") instanceof ListAnimalsConverter);
		assertTrue(applicationContest.getBean("listAnimalsResponse") instanceof ListAnimalsResponse);
	}

	@Test
	public void testFlowListAnimalsByIdExistsSuccess() {
		assertNotNull(applicationContest.getBean("listAnimalsByIdValidate"));
		assertNotNull(applicationContest.getBean("listAnimalsByIdLoad"));
		assertNotNull(applicationContest.getBean("listAnimalsByIdLoadValidate"));
		assertNotNull(applicationContest.getBean("listAnimalsByIdConverter"));
		assertNotNull(applicationContest.getBean("listAnimalsByIdResponse"));
	}

	@Test
	public void testFlowListAnimalsByIdInstanceofSuccess() {
		assertTrue(applicationContest.getBean("listAnimalsByIdValidate") instanceof ListAnimalsByIdValidate);
		assertTrue(applicationContest.getBean("listAnimalsByIdLoad") instanceof ListAnimalsByIdLoad);
		assertTrue(applicationContest.getBean("listAnimalsByIdLoadValidate") instanceof ListAnimalsByIdLoadValidate);
		assertTrue(applicationContest.getBean("listAnimalsByIdConverter") instanceof ListAnimalsByIdConverter);
		assertTrue(applicationContest.getBean("listAnimalsByIdResponse") instanceof ListAnimalsByIdResponse);
	}

}
