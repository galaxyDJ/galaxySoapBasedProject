package com.wu.exception;

public class NoContentFoundException extends RuntimeException {

	public NoContentFoundException() {

		super();
	}

	public NoContentFoundException(String name) {

		super(name);

	}

	public NoContentFoundException(String name,Throwable throwable) {

		super(name,throwable);

	}
	
}
