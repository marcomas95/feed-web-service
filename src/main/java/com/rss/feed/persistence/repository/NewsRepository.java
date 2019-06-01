package com.rss.feed.persistence.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rss.feed.persistence.entitiy.News;
/**
 * The interface NewsRepository
 * @author MarcoMas
 *
 */
@Repository
public interface NewsRepository extends CrudRepository<News, String> {
	
	/**
	 * Find all news published on a date
	 * @param pubDate Publication date
	 * @return List of news
	 */
	List<News> findAllByPubDate(Date pubDate);
	
	/**
	 * Find all news published between two dates in input
	 * @param pubDateStart Start date to search
	 * @param pubDateEnd End date to search
	 * @return List of news
	 */
	List<News> findAllByPubDateBetween(Date pubDateStart, Date pubDateEnd);
	
	/**
	 * Find all news including the title ignoring case
	 * @param title Title to search
	 * @return List of news
	 */
	List<News> findAllByTitleIgnoreCaseContaining(String title);
	
	/**
	 * Retrieve all the news in the DB
	 */
	List<News> findAll();
}
