package com.ebi.person.exception;

import java.io.Serializable;

import lombok.Data;

/**
 * Error response class.
 */
@Data
public class ErrorResponse implements Serializable {

	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The HTTP status code.
	 */

	private final int status;

	/**
	 * Error message.
	 */
	private final String errorMessage;

	/**
	 * Constructor.
	 *
	 * @param newStatus
	 *            The HTTP status code.
	 * @param newErrorCode
	 *            Error code.
	 * @param newErrorMessage
	 *            Error message.
	 */
	public ErrorResponse(int newStatus, String newErrorMessage) {
		status = newStatus;
		errorMessage = newErrorMessage;
	}

}
