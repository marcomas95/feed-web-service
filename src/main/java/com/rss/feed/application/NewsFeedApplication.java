package com.rss.feed.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Class that starts the spring boot application
 * 
 * @author MarcoMas
 *
 */
@SpringBootApplication(scanBasePackages = { "com.rss.feed" })
@EntityScan(basePackages = { "com.rss.feed.persistence.entitiy" })
@EnableJpaRepositories(basePackages = { "com.rss.feed.persistence" })
@EnableScheduling
public class NewsFeedApplication {

	/**
	 * Main method to execute the Spring boot application
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsFeedApplication.class, args);
	}
}
