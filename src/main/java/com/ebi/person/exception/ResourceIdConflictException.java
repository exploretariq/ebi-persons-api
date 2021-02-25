package com.ebi.person.exception;

/**
 * Exception class for resource ID conflict.
 * 
 * @author sulaimat
 */
public class ResourceIdConflictException extends BaseException {

	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Error message format.
	 */
	private static final String ERROR_MESSAGE_FORMAT = "The ID in the resource %s does not match the ID %s in the request URI";

	/**
	 * Constructor.
	 *
	 * @param resourceId
	 *            The resource ID.
	 * @param uriResourceId
	 *            The resource ID in the request URI.
	 */
	public ResourceIdConflictException(String resourceId, String uriResourceId) {
		super(String.format(ERROR_MESSAGE_FORMAT, resourceId, uriResourceId));
	}

}
