package com.ebi.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ebi.person.exception.ResourceNotFoundException;
import com.ebi.person.model.Person;
import com.ebi.person.repository.PersonRepository;
import com.ebi.person.rsql.CustomRsqlVisitor;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	private void validate(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person add(Person person) {
		validate(person);
		return personRepository.save(person);
	}

	@Override
	public Iterable<Person> addAll(List<Person> persons) {
		// validate(person);
		return personRepository.saveAll(persons);
	}

	public Page<Person> getAll(String searchString, Pageable pageable) {
		if (searchString == null || searchString.isEmpty()) {
			return personRepository.findAll(pageable);
		}
		Node rootNode = new RSQLParser().parse(searchString);
		Specification<Person> spec = rootNode.accept(new CustomRsqlVisitor<Person>());
		return personRepository.findAll(spec, pageable);

	}

	public Person getPersonById(String id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new ResourceNotFoundException(id);
	}

}
