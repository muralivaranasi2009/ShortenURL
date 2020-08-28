/**
 * 
 */
package com.shortenurl.casestudy.urlfactory;

/**
 * @author Murali
 *
 */
public class URLFactory {

	public static URLShortner getShortURLService(String len) {
		if (len == "sixLength") {
			return new URLShortner6Impl();
		} else {
			return new URLShortner7Impl();
		}
	}
}
