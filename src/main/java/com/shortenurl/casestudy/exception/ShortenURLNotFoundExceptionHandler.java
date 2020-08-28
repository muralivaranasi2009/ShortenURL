/**
 * 
 */
package com.shortenurl.casestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Murali
 *
 */
@ControllerAdvice
public class ShortenURLNotFoundExceptionHandler {
	
	@ExceptionHandler(ShortenURLNotFoundException.class)
	public ResponseEntity<String> shortenURLNotFoundExceptionhandler(ShortenURLNotFoundException shortenURLNotFoundException) {
		return new ResponseEntity<>(shortenURLNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
