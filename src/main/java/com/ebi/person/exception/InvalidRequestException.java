package com.ebi.person.exception;

/**
 * Exception class for an invalid request.
 */
public class InvalidRequestException extends BaseException {

	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 * @param errorMessage
	 *            The error message.
	 */
	public InvalidRequestException(String errorMessage) {
		super(errorMessage);
	}
}
