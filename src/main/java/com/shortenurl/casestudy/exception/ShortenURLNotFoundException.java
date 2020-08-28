/**
 * 
 */
package com.shortenurl.casestudy.exception;

/**
 * @author Murali
 *
 */
public class ShortenURLNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public ShortenURLNotFoundException(String message) {
		super();
		this.message = message;
	}

}
