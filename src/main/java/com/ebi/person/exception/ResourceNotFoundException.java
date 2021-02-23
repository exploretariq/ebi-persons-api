package com.ebi.person.exception;

/**
 * Exception class for non-existent resource.
 */
public class ResourceNotFoundException extends BaseException {

    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Error code.
     */
    private static final String ERROR_CODE = "ebi.resource.missing";

    /**
     * Error message format.
     */
    private static final String ERROR_MESSAGE_FORMAT = "Resource with ID %s does not exist.";

    /**
     * Constructor.
     *
     * @param id The resource ID.
     */
    public ResourceNotFoundException(String id) {
        super(ERROR_CODE, String.format(ERROR_MESSAGE_FORMAT, id));
    }

}
