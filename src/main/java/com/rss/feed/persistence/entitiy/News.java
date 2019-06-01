package com.rss.feed.persistence.entitiy;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "news")
public class News {
	@Id
	@Column(name = "guid")
	private String guid;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "enclosure")
	private String enclosure;
	
	@Column(name = "pubDate")
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public News(String guid, String title, String link, String description, String enclosure, Date pubDate) {
		this.guid = guid;
		this.title = title;
		this.link = link;
		this.description = description;
		this.enclosure = enclosure;
		this.pubDate = pubDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
