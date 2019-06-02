package com.rss.feed.batch;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rss.feed.persistence.entitiy.News;
import com.rss.feed.persistence.service.NewsService;
import com.rss.feed.response.model.Rss;

@Component
public class NewsFinderBatch {

	@Value("#{'${urisList}'.split(',')}")
	private List<String> urisList;

	@Autowired
	private NewsService newsService;

	@Scheduled(cron = "${pollingCron}")
	public void insertNews() {
		System.out.println("Started batch to find news...");
		for (String uri : urisList) {
			List<News> listPerUri = getNews(uri);
			if (listPerUri != null) {
				newsService.addNews(listPerUri);
				System.out.println("Added or updated news from " + uri);
			}
		}

	}

	private List<News> getNews(String uri) {
		try {
			URL obj = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			if (responseCode == 200 && con.getContentType().toLowerCase().contains("xml")) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StreamSource xml = new StreamSource(con.getInputStream());
				Rss news = (Rss) unmarshaller.unmarshal(xml);
				return news.getChannel().getItem();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
