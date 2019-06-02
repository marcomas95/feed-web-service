package com.rss.feed.persistence.entitiy;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class Enclosure {

	@XmlAttribute
	private String url;


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
