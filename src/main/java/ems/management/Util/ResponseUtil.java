package ems.management.Util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;

public class ResponseUtil {

	private HttpHeaders httpHeaders;
	private int statusCode;
	private String message;
	private Object body;
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public HttpHeaders getRequestHeader() {
		return httpHeaders;
	}

	public void setRequestHeader(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getBody() {
		return body;
	}
	
	public void setBody(Object body) {
		this.body = body;
	}
	
}
