package com.ebi.person.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

/**
 * The User object representing the authentication aspects.
 * 
 * @author sulaimat
 *
 */
@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
	/**
	 * Serial version ID.
	 */
	private static final long serialVersionUID = -1741287068811241588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;
}
