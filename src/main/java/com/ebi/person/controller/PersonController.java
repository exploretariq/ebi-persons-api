package com.ebi.person.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.person.model.Person;
import com.ebi.person.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/persons")
@Slf4j
public class PersonController {

	@Autowired
	private PersonService personService;

	private void validate(@Valid Person person) {
		// TODO Auto-generated method stub

	}

	private void validate(@Valid Person[] persons) {
		// TODO Auto-generated method stub

	}

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
	 * Adds a new {@link Person} resource in the system
	 *
	 * @param person
	 *            the person to be added.
	 * @return the added person.
	 */
	@PostMapping(path = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Person>> addAll(@Valid @RequestBody Person[] persons) {
		log.info("Persons batch call");
		validate(persons);
		Iterable<Person> addedPersons = personService.addAll(Arrays.asList(persons));
		return new ResponseEntity<>(addedPersons, HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Person> getAllUsers(@RequestParam(value = "search", required = false) String search, Pageable pageable) {
		return personService.getAll(search, pageable);
	}

	@GetMapping(path = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getById(@PathVariable("personId") String personId) {
		Person person = personService.getPersonById(personId);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

}
