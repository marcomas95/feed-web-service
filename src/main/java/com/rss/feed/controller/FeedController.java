package com.rss.feed.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rss.feed.persistence.entitiy.News;
import com.rss.feed.persistence.service.NewsService;
import com.rss.feed.response.model.CustomError;
import com.rss.feed.response.model.ErrorResponse;
import com.rss.feed.response.model.Response;
import com.rss.feed.response.model.SuccessResponse;

/**
 * Controller that expose the services
 * 
 * @author MarcoMas
 *
 */
@RestController
public class FeedController {

	/**
	 * Service to execute queryes
	 */
	@Autowired
	private NewsService newsService;

	/**
	 * Dateformat for dates
	 */
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/**
	 * Retrieve all the news inside the DB
	 * 
	 * @return List of news
	 */
	@GetMapping(value = "/getAllNews")
	public Response getAllNews() {
		List<News> allNews = newsService.getAllNews();
		SuccessResponse<News> resp = new SuccessResponse<News>();
		resp.setSuccess(allNews);
		return resp;
	}

	/**
	 * Retrive all the news after the pubDate
	 * 
	 * @param pubDate  Publication date
	 * @param servResp HTTP response
	 * @return list of news
	 */
	@GetMapping(value = "/getNewsAfterPubDate")
	public Response getNewsAfterPubDate(@RequestParam String pubDate, HttpServletResponse servResp) {
		Date dateToSearch;
		try {
			dateToSearch = dateFormat.parse(pubDate);
			String nowS = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			Date now = dateFormat.parse(nowS);
			List<News> dateNews = newsService.getNewsBetweenDates(dateToSearch, now);
			SuccessResponse<News> resp = new SuccessResponse<News>();
			resp.setSuccess(dateNews);
			return resp;
		} catch (ParseException e) {
			ErrorResponse err = new ErrorResponse(new CustomError(406, "Invalid date format"));
			servResp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return err;
		}
	}

	/**
	 * Retrieve all the news between the pubDateStart and the pubDateEnd
	 * 
	 * @param pubDateStart Start publication date
	 * @param pubDateEnd   ENd publication date
	 * @param servResp     HTTP response
	 * @return list of news
	 */
	@GetMapping(value = "/getNewsBetweenDates")
	public Response getNewsBetweenDates(@RequestParam String pubDateStart, @RequestParam String pubDateEnd,
			HttpServletResponse servResp) {
		Date firstDate;
		Date secondDate;
		try {
			firstDate = dateFormat.parse(pubDateStart);
			secondDate = dateFormat.parse(pubDateEnd);
			List<News> dateNews = newsService.getNewsBetweenDates(firstDate, secondDate);
			SuccessResponse<News> resp = new SuccessResponse<News>();
			resp.setSuccess(dateNews);
			return resp;
		} catch (ParseException e) {
			ErrorResponse err = new ErrorResponse(new CustomError(406, "Invalid date format"));
			servResp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return err;
		}
	}

	/**
	 * Retrieve all the news containing the title
	 * 
	 * @param title    Title to search
	 * @param servResp HTTP response
	 * @return list of news
	 */
	@GetMapping(value = "/getNewsContainingTitle")
	public Response getNewsContainingTitle(@RequestParam String title, HttpServletResponse servResp) {
		List<News> newsWithTitle = this.newsService.getNewsContainingTitle(title);
		SuccessResponse<News> resp = new SuccessResponse<News>();
		resp.setSuccess(newsWithTitle);
		return resp;
	}

}
