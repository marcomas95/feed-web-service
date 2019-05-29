package com.rss.feed.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rss.feed.persistence.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository repository;
	
	
}
