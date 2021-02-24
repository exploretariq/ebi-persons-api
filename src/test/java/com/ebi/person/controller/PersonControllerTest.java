package com.ebi.person.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebi.person.exception.ResourceIdConflictException;
import com.ebi.person.model.Person;
import com.ebi.person.service.PersonService;

@RunWith(SpringRunner.class)
public class PersonControllerTest {

	@InjectMocks
	private PersonController personController;

	@Mock
	protected PersonService personService;

	private Person getPerson() {
		return new Person().setId("ABC").setFirstName("Jos").setLastName("Butler").setAge(35);
	}

	@Test
	public void testAddValid() {
		Person person = getPerson();
		Mockito.when(personService.add(ArgumentMatchers.any(Person.class))).thenReturn(person);
		final ResponseEntity<Person> entity = personController.add(person);

		final Person body = entity.getBody();
		Assert.assertNotNull(body);
		System.out.println(body.toString());
		assertEquals(body, person);
	}

	@Test
	public void testUpdateValid() {
		Person person = getPerson();
		Mockito.when(personService.update(ArgumentMatchers.any(Person.class))).thenReturn(person);
		final ResponseEntity<Person> entity = personController.update(person, person.getId());

		final Person body = entity.getBody();
		Assert.assertNotNull(body);
		System.out.println(body.toString());
		assertEquals(body, getPerson());
	}

	@Test(expected = ResourceIdConflictException.class)
	public void testUpdateConflict() {
		Person person = getPerson();
		Mockito.when(personService.update(ArgumentMatchers.any(Person.class))).thenReturn(person);
		personController.update(person, "Conflict");
	}

	@Test
	public void testGetById() {
		Person person = getPerson();
		Mockito.when(personService.getPersonById(ArgumentMatchers.any(String.class))).thenReturn(person);
		ResponseEntity<Person> entity = personController.getById(person.getId());
		final Person body = entity.getBody();
		Assert.assertNotNull(body);
		System.out.println(body.toString());
		assertEquals(body, getPerson());
	}
	
	@Test
	public void testGet() {
		Person person = getPerson();
		Mockito.when(personService.getPersonById(ArgumentMatchers.any(String.class))).thenReturn(person);
		ResponseEntity<Person> entity = personController.getById(person.getId());
		final Person body = entity.getBody();
		Assert.assertNotNull(body);
		System.out.println(body.toString());
		assertEquals(body, getPerson());
	}

}
