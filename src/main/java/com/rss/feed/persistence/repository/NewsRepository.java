package com.rss.feed.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rss.feed.persistence.entitiy.News;

@Repository
public interface NewsRepository extends CrudRepository<News, String> {
	List<News> findByPubDate(String pubDate);
}
