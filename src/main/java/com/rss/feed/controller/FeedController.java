package com.rss.feed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {
	
	@GetMapping(value="/hello")
	public String helloWorld() {
		return ("Hello World!");
	}
	
	
}
