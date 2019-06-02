package com.rss.feed.response.model;

import java.util.List;

public class SuccessResponse<T> implements Response {
	private List<T> success;

	public SuccessResponse() {
	};

	public List<T> getSuccess() {
		return success;
	}

	public void setSuccess(List<T> success) {
		this.success = success;
	}
}
