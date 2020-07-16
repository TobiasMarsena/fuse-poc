package org.i3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hello")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hello {
	@XmlElement
	private String greeting;
	@XmlElement
	private String time;
	
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

	@Override
	public String toString() {
		return "Hello [greeting=" + greeting + ", time=" + time + "]";
	}
	
}
