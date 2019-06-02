package com.rss.feed.response.model;

public class ErrorResponse implements Response {
	private CustomError error;
	
	public ErrorResponse(){	
	};

	public ErrorResponse(CustomError error) {
		super();
		this.error = error;
	}

	public CustomError getError() {
		return error;
	}

	public void setError(CustomError error) {
		this.error = error;
	}
}
