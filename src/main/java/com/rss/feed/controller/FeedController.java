package com.rss.feed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rss.feed.persistence.entitiy.News;
import com.rss.feed.persistence.service.NewsService;
import com.rss.feed.response.model.Response;
import com.rss.feed.response.model.SuccessResponse;

@RestController
public class FeedController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping(value="/getAllNews")
	public Response getAllNews() {
		List<News> allNews = newsService.getAllNews();
		SuccessResponse<News> resp = new SuccessResponse<News>();
		resp.setSuccess(allNews);
		return resp;
	}
	
	@GetMapping(value="/getNewsByPubDate")
	public Response getNewsByPubDate () {
		return null;
		
	}
	
	
	
}
