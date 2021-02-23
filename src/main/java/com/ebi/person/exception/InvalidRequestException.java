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
	 * @param errorCode
	 *            Error code.
	 * @param errorMessage
	 *            The error message.
	 */
	public InvalidRequestException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
