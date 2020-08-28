/**
 * 
 */
package com.shortenurl.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shortenurl.casestudy.entity.ShortenURL;

/**
 * @author Murali
 *
 */
@Repository
public interface ShortenURLRepository extends CrudRepository<ShortenURL, String> {

}
