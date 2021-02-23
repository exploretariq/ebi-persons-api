package com.ebi.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * A POJO representing a person resource with attributes defined for its own.
 */
@Entity
@Table(name = "persons")
@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
public class Person {

	/**
	 * Segment ID.
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "com.ebi.person.common.UUIDGeneratorStrategy")
	@GeneratedValue(generator = "uuid")
	private String id;

	/**
	 * The first name of the person
	 */
	@Column
	@JsonProperty("first_name")
	@NotNull(message = "'first_name' is mandatory")
	@NotEmpty(message = "'first_name' cannot be empty")
	@Size(max = 128, message = "'first_name' should be of max 128 characters")
	private String firstName;

	/**
	 * The last name of the person.
	 */
	@Column
	@JsonProperty("last_name")
	@NotNull(message = "'last_name' is mandatory")
	@NotEmpty(message = "'last_name' cannot be empty")
	@Size(max = 128, message = "'last_name' should be of max 128 characters")
	private String lastName;
	
	/**
	 * The age of the person.
	 */
	@Column
	@Min(value = 1)
	@Max(value = 190)
	private Integer age;

	/**
	 * The favourite color of the person. TODO : This can be represented as enum if we have
	 * a predefined colour palette available or as hexcode for performance improvement.
	 */
	@Column
	@JsonProperty("favourite_colour")
	private String favouriteColour;

}
