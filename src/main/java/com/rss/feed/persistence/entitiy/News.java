package com.rss.feed.persistence.entitiy;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.rss.feed.utility.DateTimeAdapter;

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

	@Column(name = "description", length = 10000)
	private String description;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "url", column = @Column(name = "image_url")) })
	private Enclosure enclosure;

	
	@Column(name = "pub_date")
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public News() {
	};

	public News(String guid, String title, String link, String description, Enclosure enclosure, Date pubDate) {
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

	public Enclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	@XmlJavaTypeAdapter(value=DateTimeAdapter.class)
	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
