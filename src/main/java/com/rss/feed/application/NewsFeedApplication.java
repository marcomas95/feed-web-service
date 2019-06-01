package com.rss.feed.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages={"com.rss.feed"})
@EntityScan(basePackages = {"com.rss.feed.persistence.entitiy"})
@EnableJpaRepositories(basePackages= {"com.rss.feed.persistence"})
@EnableScheduling
public class NewsFeedApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NewsFeedApplication.class, args);
	}
}
