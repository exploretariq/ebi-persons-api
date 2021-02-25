package com.ebi.person.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ebi.person.model.Person;

/**
 * Service for {@link Person} resource
 * 
 * @author sulaimat
 *
 */
public interface PersonService {

	/**
	 * Adds a person
	 * 
	 * @param person
	 *            the person to be added.
	 * @return person.
	 */
	public Person add(Person person);

	/**
	 * Updates the person.
	 * 
	 * @param person
	 *            the person to be updated.
	 * @return the person.
	 */
	public Person update(Person person);

	/**
	 * Searches persons based on search input.
	 * 
	 * @param seacrhString
	 *            the search string
	 * @param pageable
	 *            the pageable object
	 * @return the pageable persons.
	 */
	public Page<Person> getAll(String seacrhString, Pageable pageable);

	/**
	 * Gets person by ID
	 * 
	 * @param id
	 *            the person id.
	 * @return the person.
	 */
	public Person getPersonById(String id);

	/**
	 * Delete person by ID
	 * 
	 * @param personId
	 *            the person id.
	 */
	public void delete(String personId);

	/**
	 * Adds persons
	 * 
	 * @param persons
	 *            the persons list.
	 * @return the iterable of persons.
	 */
	public Iterable<Person> addAll(List<Person> persons);

}
