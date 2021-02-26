package com.ebi.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.person.exception.InvalidRequestException;
import com.ebi.person.model.User;
import com.ebi.person.repository.UserRepository;

/**
 * @author sulaimat
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/signup")
	public void signUp(@RequestBody User user) {

		// TODO : Add more data validations.
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			throw new InvalidRequestException(String.format("User with username %s exists ", user.getUsername()));
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		userRepository.save(user);
	}

}
