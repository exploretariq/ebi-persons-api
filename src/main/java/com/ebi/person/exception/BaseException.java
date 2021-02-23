package com.ebi.person.exception;

import lombok.Getter;

/**
 * Base exception class.
 */
public abstract class BaseException extends RuntimeException {

    /**
	 *  The serial version UID.
	 */
	private static final long serialVersionUID = 1593542004506206233L;

	/**
     * Error code.
     */
    @Getter
    private String errorCode;

    /**
     * Constructor.
     *
     * @param errorMessage Error message.
     */
    protected BaseException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructor.
     *
     * @param newErrorCode    Error code.
     * @param newErrorMessage Error message.
     */
    protected BaseException(String newErrorCode, String newErrorMessage) {
        super(newErrorMessage);
        errorCode = newErrorCode;
    }

}
