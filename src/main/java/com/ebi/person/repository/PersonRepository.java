package com.ebi.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ebi.person.model.Person;

/**
 * Spring JPA repository for {@link Person} resource.
 * 
 * @author sulaimat
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {


}
