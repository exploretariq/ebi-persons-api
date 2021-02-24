package com.ebi.person.exception;


import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EbiExceptionHandler {

	/**
	 * Handler to handle {@link InvalidRequestException}.
	 *
	 * @param exception
	 *            The exception.
	 * @return The error response.
	 */
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handle(InvalidRequestException exception) {
		log.error("Caught InvalidRequestException. Error message - {}", exception.getMessage());
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

	/**
	 * Handler to handle {@link ResourceNotFoundException}.
	 *
	 * @param exception
	 *            The exception.
	 * @return The error response.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handle(ResourceNotFoundException exception) {
		log.error("Caught ResourceNotFoundException. Error message - {}", exception.getMessage());
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

	/**
	 * Handler to handle {@link ResourceIdConflictException}.
	 *
	 * @param exception
	 *            The exception.
	 * @return The error response.
	 */
	@ExceptionHandler(ResourceIdConflictException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorResponse handle(ResourceIdConflictException exception) {
		log.error("Caught ResourceIdConflictException. Error message - {}", exception.getMessage());
		return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
	}

	/**
	 * Handler to handle {@link MethodArgumentNotValidException}.
	 *
	 * @param exception
	 *            The exception.
	 * @return The error response.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ErrorResponse handle(MethodArgumentNotValidException exception) {
		log.error("Caught MethodArgumentNotValidException. Error message - {}", exception.getMessage());
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getBindingResult().getAllErrors().stream()
				.map(error -> error.getDefaultMessage()).collect(Collectors.toSet()).toString());
	}

	/**
	 * Handler to handle all other exceptions.
	 *
	 * @param exception
	 *            The exception.
	 * @return The error response.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public final ErrorResponse handle(Exception exception) {
		log.error("An error occurred. Error message - {}. Cause - {}, Stack trace - {}", exception.getMessage(),
				exception.getCause(), exception.getStackTrace());
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal error occurred");
	}

}
