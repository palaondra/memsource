package com.pala.memsource.memsource.config;

import java.time.OffsetDateTime;

import com.pala.memsource.memsource.exception.ErrorDetail;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.exception.UsernameAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Class for defining exception handling.
 */
@RestControllerAdvice
public class GlobalCustomExceptionHandler {
    
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorDetail usernameAlreadyExistsException(UsernameAlreadyExistsException exception) {
		return new ErrorDetail(OffsetDateTime.now(), exception.getMessage());
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetail userNotFoundException(UserNotFoundException exception) {
		return new ErrorDetail(OffsetDateTime.now(), exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDetail methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return new ErrorDetail(OffsetDateTime.now(), exception.getMessage());
	}

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDetail memSourceRestClientCallingException(HttpClientErrorException exception) {
		return new ErrorDetail(OffsetDateTime.now(), exception.getMessage());
	}

}
