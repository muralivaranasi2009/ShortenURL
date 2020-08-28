/**
 * 
 */
package com.shortenurl.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shortenurl.casestudy.entity.ShortenURL;
import com.shortenurl.casestudy.exception.ShortenURLNotFoundException;

/**
 * @author Murali
 *
 */
@Service
public interface ShortenService {

	public String getShortenURL(String longUrl);

	public String getHighShortenURL(String longUrl);

	public String getLongURL(String shortURL) throws ShortenURLNotFoundException;

	public List<ShortenURL> getAllURLs();
}
