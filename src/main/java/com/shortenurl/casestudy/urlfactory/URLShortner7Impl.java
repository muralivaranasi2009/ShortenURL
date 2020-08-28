/**
 * 
 */
package com.shortenurl.casestudy.urlfactory;

/**
 * @author Murali
 *
 */
public class URLShortner7Impl implements URLShortner {

	@Override
	public String getShortURL(String longURL) {
		int lengthOfThePattern = SHORTNER_CHAR_PATTERN.length();
		String shortURL = "";
		for (int i = 0; i < 7; i++) {
			shortURL += SHORTNER_CHAR_PATTERN.charAt((int) Math.floor(Math.random() * lengthOfThePattern));
		}
		return shortURL;
	}

}
