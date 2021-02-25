package com.ebi.person.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebi.person.common.Constants;
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

	private Person getUpdatedPerson() {
		long currentTimeMillis = System.currentTimeMillis();
		return getPerson().setCreatedBy(Constants.DEFAULT_USER).setCreationInstant(currentTimeMillis)
				.setUpdatedBy(Constants.DEFAULT_USER).setUpdatedInstant(currentTimeMillis);
	}

	private List<Person> getPersons() {

		List<Person> persons = Arrays.asList(getPerson());
		return persons;
	}

	private Page<Person> getPagePersons() {
		Page<Person> page = new PageImpl<>(getPersons());
		return page;
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		Person person = getPerson();
		Person updatePerson = getUpdatePerson();
		Optional<Person> optionalPerson = Optional.of(person);
		Optional<Person> optionalUpdatePerson = Optional.of(updatePerson);
		Optional<Person> invalidPerson = Optional.empty();
		Mockito.when(personRepository.findById(person.getId())).thenReturn(optionalPerson);
		Mockito.when(personRepository.findById(updatePerson.getId())).thenReturn(optionalUpdatePerson);
		Mockito.when(personRepository.findById("invalid")).thenReturn(invalidPerson);
		Person addedPerson = getAddedPerson();
		Person updatedPerson = getUpdatedPerson();
		Mockito.when(personRepository.save(ArgumentMatchers.any(Person.class))).thenReturn(addedPerson);
		Mockito.when(personRepository.save(ArgumentMatchers.any(Person.class))).thenReturn(updatedPerson);

		Page<Person> page = getPagePersons();
		Mockito.when(personRepository.findAll(ArgumentMatchers.any(Specification.class),
				ArgumentMatchers.any(Pageable.class))).thenReturn(page);
		Mockito.when(personRepository.findAll(ArgumentMatchers.any(Pageable.class))).thenReturn(page);

	}

	@Test
	public void testAddPerson() {
		Person person = getPerson();
		Person addedPerson = personService.add(person);
		assertNotNull(addedPerson.getCreationInstant());
		assertNotNull(addedPerson.getCreatedBy());
		assertNotNull(addedPerson.getUpdatedInstant());
		assertNotNull(addedPerson.getUpdatedBy());
		assertEquals(person.getId(), addedPerson.getId());
	}

	@Test
	public void testUpdatePerson() {
		Person person = getPerson();
		Person updatedPerson = personService.update(person);
		assertNotNull(updatedPerson.getUpdatedInstant());
		assertNotNull(updatedPerson.getUpdatedBy());
		assertEquals(person.getId(), updatedPerson.getId());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testUpdateInvalidPerson() {
		personService.update(getInvalidPerson());
	}

	@Test
	public void testGetPersonByIdValid() {
		Person personById = personService.getPersonById("ABC");
		assertEquals("ABC", personById.getId());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testDeletePersonByInvalidId() {
		personService.delete("invalid");
	}

	@Test
	public void testDeletePersonById() {
		personService.delete("ABC");
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testGetPersonByIdInvalid() {
		personService.getPersonById("invalid");

	}

	@Test
	public void testGetAll() {
		final Pageable pageable = PageRequest.of(0, 10);
		Page<Person> page = personService.getAll("firstName==Jos", pageable);
		assertEquals(getPersons(), page.getContent());
	}

	private Person getPerson() {
		Person person = new Person().setId("ABC").setFirstName("Jos").setLastName("Butler").setAge(35);
		return person;
	}

	private Person getUpdatePerson() {
		Person person = new Person().setId("ABC_UPDATE").setFirstName("Jos").setLastName("Butler").setAge(35);
		return person;
	}

	private Person getInvalidPerson() {
		Person person = new Person().setId("invalid");
		return person;
	}

	private Person getAddedPerson() {
		long currentTimeMillis = System.currentTimeMillis();
		return getPerson().setCreatedBy(Constants.DEFAULT_USER).setCreationInstant(currentTimeMillis)
				.setUpdatedBy(Constants.DEFAULT_USER).setUpdatedInstant(currentTimeMillis);
	}

}
