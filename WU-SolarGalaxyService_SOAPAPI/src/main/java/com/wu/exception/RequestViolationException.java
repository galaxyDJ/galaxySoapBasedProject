package com.wu.exception;

public class RequestViolationException extends RuntimeException {

	public RequestViolationException() {

		super();
	}

	public RequestViolationException(String name) {

		super(name);

	}

	public RequestViolationException(String name,Throwable throwable) {

		super(name,throwable);

	}
	
}
