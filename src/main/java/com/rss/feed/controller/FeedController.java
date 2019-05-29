package com.rss.feed.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EntityScan(basePackages = {"com.rss.feed.persistence.entitiy"})
public class FeedController {
	
	@GetMapping(value="/hello")
	public String helloWorld() {
		return ("Hello World!");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FeedController.class, args);
	}
}
