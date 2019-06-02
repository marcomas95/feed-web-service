package com.rss.feed.persistence.service;

import java.util.Date;
import java.util.List;

import com.rss.feed.persistence.entitiy.News;
/**
 * Interface defining service methods
 * @author MarcoMas
 *
 */
public interface NewsService {
	
	/**
	 * Insert news list in the DB
	 * @param newsList The news to add
	 */
	public void addNews(List<News> newsList);

	/**
	 * Retrieve all the news in the DB
	 * @return List of news
	 */
	public List<News> getAllNews();
	
	
	/**
	 * Retrieve all the news published between the two dates in input
	 * @param pubDateStart Start date to search
	 * @param pubDateEnd End date to search
	 * @return List of news
	 */
	public List<News> getNewsBetweenDates(Date pubDateStart, Date pubDateEnd);
	
	/**
	 * Retrieve all the news including the title ignoring case
	 * @param title Title to search
	 * @return List of news
	 */
	public List<News> getNewsContainingTitle(String title);
}
