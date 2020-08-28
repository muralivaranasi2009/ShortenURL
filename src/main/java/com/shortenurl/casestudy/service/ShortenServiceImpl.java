/**
 * 
 */
package com.shortenurl.casestudy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortenurl.casestudy.entity.ShortenURL;
import com.shortenurl.casestudy.exception.ShortenURLNotFoundException;
import com.shortenurl.casestudy.repository.ShortenURLRepository;
import com.shortenurl.casestudy.urlfactory.URLFactory;

/**
 * @author Murali
 *
 */
@Service
public class ShortenServiceImpl implements ShortenService {

	@Autowired
	ShortenURLRepository shortenURLRepository;

	@Override
	public String getShortenURL(String longUrl) {
		return getShortURL("sixLength", longUrl);
	}

	@Override
	public String getHighShortenURL(String longUrl) {
		return getShortURL("sevenLength", longUrl);
	}

	private String getShortURL(String shortenURLLength, String longUrl) {

		String shortURL = URLFactory.getShortURLService(shortenURLLength).getShortURL(longUrl);
		if (shortenURLRepository.existsById(shortURL)) {
			return getShortURL("sixLength", longUrl);
		} else {
			shortenURLRepository.save(new ShortenURL(shortURL, longUrl));
			return shortURL;
		}
	}

	@Override
	public String getLongURL(String shortURL) throws ShortenURLNotFoundException {
		Optional<ShortenURL> shortenURLOptional = shortenURLRepository.findById(shortURL);
		if (shortenURLOptional.isPresent()) {
			return shortenURLOptional.get().getLongURL();
		} else {
			throw new ShortenURLNotFoundException("Shorten URL Not Found");
		}
	}

	@Override
	public List<ShortenURL> getAllURLs() {
		List<ShortenURL> shortenURLList = new ArrayList<>();
		Iterator<ShortenURL> shortenURLIterator = shortenURLRepository.findAll().iterator();
		while (shortenURLIterator.hasNext()) {
			shortenURLList.add(shortenURLIterator.next());
		}
		return shortenURLList;
	}

}
