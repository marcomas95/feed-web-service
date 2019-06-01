package com.rss.feed.response.model;

import java.util.List;

import com.rss.feed.persistence.entitiy.News;

public class Channel {
	private List<News> item;

	public List<News> getItem() {
		return item;
	}

	public void setItem(List<News> item) {
		this.item = item;
	}
}
