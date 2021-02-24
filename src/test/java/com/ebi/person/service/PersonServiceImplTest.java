package com.ebi.person.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebi.person.exception.ResourceNotFoundException;
import com.ebi.person.model.Person;
import com.ebi.person.repository.PersonRepository;

@RunWith(SpringRunner.class)
public class PersonServiceImplTest {

	@TestConfiguration
	static class PersonServiceImplTestConfiguration {
		@Bean
		public PersonService personService() {
			return new PersonServiceImpl();
		}
	}

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@Before
	public void setUp() {
		Person person = new Person().setId("ABC").setFirstName("Jos").setLastName("Butler").setAge(35);
		Optional<Person> optionalPerson = Optional.of(person);
		Optional<Person> invalidPerson = Optional.empty();
		Mockito.when(personRepository.findById(person.getId())).thenReturn(optionalPerson);
		Mockito.when(personRepository.findById("invalid")).thenReturn(invalidPerson);
	}

	@Test
	public void testGetPersonByIdValid() {
		Person personById = personService.getPersonById("ABC");
		assertEquals("ABC", personById.getId());

	}

	//@Test(expected = ResourceNotFoundException.class)
	public void testGetPersonByIdInvalid() {
		personService.getPersonById("invalid");

	}

}
