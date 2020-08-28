/**
 * 
 */
package com.shortenurl.casestudy.urlfactory;

/**
 * @author Murali
 *
 */
public interface URLShortner {

	public static final String SHORTNER_CHAR_PATTERN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	public String getShortURL(String longURL);
}
