package com.rss.feed.response.model;

public class CustomError {
	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public CustomError() {
	};

	public CustomError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
