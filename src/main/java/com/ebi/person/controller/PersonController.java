package com.ebi.person.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.person.exception.ResourceIdConflictException;
import com.ebi.person.model.Person;
import com.ebi.person.service.PersonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for {@link Person}
 * 
 * @author sulaimat
 *
 */
@RestController
@RequestMapping(value = "/persons")
@Slf4j
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * Adds a new {@link Person} resource in the system
	 *
	 * @param person
	 *            the person to be added.
	 * @return the added person.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> add(@Valid @RequestBody Person person) {

		validate(person);
		Person added = personService.add(person);
		log.info("Added person with id - {}", added.getId());
		return new ResponseEntity<>(added, HttpStatus.CREATED);
	}

	/**
	 * Updates a new {@link Person} resource in the system
	 *
	 * @param person
	 *            the person to be updated.
	 * @return the udpated person.
	 */
	@PutMapping(path = "/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> update(@Valid @RequestBody Person person, @PathVariable("personId") String personId) {

		validateUpdate(personId, person);
		Person updated = personService.update(person);
		log.info("Updated person with id - {}", updated.getId());
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	/**
	 * Searches the persons based on search string and page parmeters.
	 * 
	 * @param search
	 *            the rsql search string
	 * @param pageable
	 *            the pageable info
	 * @return the page of persons.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Person> getAllUsers(@RequestParam(value = "search", required = false) String search,
			Pageable pageable) {
		return personService.getAll(search, pageable);
	}

	/**
	 * Gets person by ID.
	 * 
	 * @param personId
	 *            the person id
	 * @return the person.
	 */
	@GetMapping(path = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getById(@PathVariable("personId") String personId) {
		Person person = personService.getPersonById(personId);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	/**
	 * Deletes the person by ID.
	 * 
	 * @param personId
	 *            the person id
	 * @return void.
	 */
	@DeleteMapping(path = "/{personId}")
	public ResponseEntity<Void> delete(@PathVariable("personId") String personId) {
		personService.delete(personId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Adds many persons resource.
	 *
	 * @param person
	 *            the persons to be added.
	 * @return the added persons.
	 */
	@PostMapping(path = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Person>> addAll(@Valid @RequestBody Person[] persons) {
		log.info("Persons batch call");
		validate(persons);
		Iterable<Person> addedPersons = personService.addAll(Arrays.asList(persons));
		return new ResponseEntity<>(addedPersons, HttpStatus.CREATED);
	}

	/**
	 * 
	 * 
	 * @param person
	 */
	private void validate(Person person) {
		// TODO: Add validation logic based on business rules.

	}

	/**
	 * @param persons
	 */
	private void validate(Person[] persons) {
		// TODO: Add validation logic based on business rules.

	}

	/**
	 * Validates the person id against the person resource.
	 * 
	 * @param personId the person id.
	 * @param person the person object.
	 */
	private void validateUpdate(String personId, Person person) {
		if (!personId.equals(person.getId())) {
			throw new ResourceIdConflictException(person.getId(), personId);
		}

	}

}
