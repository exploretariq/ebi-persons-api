package com.ebi.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ebi.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {

	/*public Page<Person> findbyFirstName(String firstName, Pageable page);

	public Page<Person> findbyAgeGreaterThanEqual(Integer age, Pageable page);*/


}
