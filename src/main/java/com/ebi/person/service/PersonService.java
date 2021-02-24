package com.ebi.person.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ebi.person.model.Person;

public interface PersonService {

	public Person add(Person person);

	public Person update(Person person);

	public Page<Person> getAll(String seacrhString, Pageable pageable);

	public Person getPersonById(String id);

	public void delete(String personId);

	public Iterable<Person> addAll(List<Person> persons);

}
