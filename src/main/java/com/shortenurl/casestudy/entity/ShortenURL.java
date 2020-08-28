/**
 * 
 */
package com.shortenurl.casestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Murali
 *
 */
@Entity
@Table(name = "shortenurl")
public class ShortenURL {

	@Id
	@Column(name = "short_url")
	private String shortURL;

	@Column(name = "long_url")
	private String longURL;

	public ShortenURL() {
	}
	
	public ShortenURL(String shortURL, String longURL) {
		this.shortURL = shortURL;
		this.longURL = longURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public String getLongURL() {
		return longURL;
	}

	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}

	@Override
	public String toString() {
		return "ShortenURL [shortURL=" + shortURL + ", longURL=" + longURL + "]";
	}

}
