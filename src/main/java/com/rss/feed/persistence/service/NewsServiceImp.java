package com.rss.feed.persistence.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rss.feed.persistence.entitiy.News;
import com.rss.feed.persistence.repository.NewsRepository;

@Service
public class NewsServiceImp implements NewsService {

	/**
	 * News repository
	 */
	@Autowired
	private NewsRepository newsRepo;

	@Override
	public void addNews(List<News> newsList) {
		this.newsRepo.saveAll(newsList);
		
	}

	@Override
	public List<News> getAllNews() {
		return this.newsRepo.findAll();
	}


	@Override
	public List<News> getNewsBetweenDates(Date pubDateStart, Date pubDateEnd) {
		return this.newsRepo.findAllByPubDateBetween(pubDateStart, pubDateEnd);
	}

	@Override
	public List<News> getNewsContainingTitle(String title) {
		return this.newsRepo.findAllByTitleIgnoreCaseContaining(title);
	}
	
	
}
