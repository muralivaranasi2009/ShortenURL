/**
 * 
 */
package com.shortenurl.casestudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortenurl.casestudy.entity.ShortenURL;
import com.shortenurl.casestudy.exception.ShortenURLNotFoundException;
import com.shortenurl.casestudy.service.ShortenService;

/**
 * @author Murali
 *
 */
@RestController
public class ShortenURLController {

	@Autowired
	ShortenService shortenService;

	@RequestMapping("/shortenURL")
	public ResponseEntity<String> getShortenURL(@RequestParam String longUrl) {
		return new ResponseEntity<>(shortenService.getShortenURL(longUrl),HttpStatus.OK);
	}

	@RequestMapping("/highShortenURL")
	public ResponseEntity<String> getHighShortenURL(@RequestParam String longUrl) {
		return new ResponseEntity<>(shortenService.getHighShortenURL(longUrl),HttpStatus.OK);
	}

	@RequestMapping("/r/{shortenURL}")
	public void routeURL(@PathVariable String shortenURL, HttpServletResponse response)
			throws IOException, ShortenURLNotFoundException {
		response.sendRedirect(shortenService.getLongURL(shortenURL));
	}

	@RequestMapping("/listShortenURLS")
	public ResponseEntity<List<ShortenURL>> getAll() {
		return new ResponseEntity<>(shortenService.getAllURLs(),HttpStatus.OK);
	}
}
