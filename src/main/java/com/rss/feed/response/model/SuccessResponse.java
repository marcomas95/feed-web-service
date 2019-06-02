package com.rss.feed.response.model;

import java.util.List;

/**
 * Response in success case
 * @author MarcoMas
 *
 * @param <T>
 */
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
