package com.microservices.webservice.restfull.helloWorld;

public class HelloWorldBean {
	
	String message ;
	
	public HelloWorldBean(String message) {
		this.message = message;	
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelloWorldBean [message=").append(message).append("]");
		return builder.toString();
	}


}
