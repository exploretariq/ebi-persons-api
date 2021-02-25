package com.ebi.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebi.person.model.User;

/**
 * Spring JPA repository for {@link User} resource.
 * 
 * @author sulaimat
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 
	 * Finds user by username.
	 * 
	 * @param username
	 *            the user name
	 * @return the user object.
	 */
	public User findByUsername(String username);

}
