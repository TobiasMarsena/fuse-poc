package org.i3.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "hello")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hello {
	
	@XmlElement
	private Map<String, Object> headers;
	@XmlElement
	private String greeting;
	@XmlElement
	private String time;
	@JsonInclude(Include.NON_NULL)
	private User user;
	
	public Hello() {
	}
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "Hello [headers=" + headers + ", greeting=" + greeting + ", time=" + time + ", user=" + user + "]";
	}
	
}
