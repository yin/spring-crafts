package com.github.yin.spring.crafts.runtime;

public class HelloWorld {
	private String message;
	static int counter = 0;

	public HelloWorld() {
		updateCount();
	}

	private static synchronized void updateCount() {
		counter++;
	}

	public void setMessage(String message) {
		this.message = message + ' ' + counter;
	}

	public String getMessage() {
		return message;
	}
}