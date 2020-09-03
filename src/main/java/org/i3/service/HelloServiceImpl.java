package org.i3.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.camel.Exchange;
import org.i3.model.Hello;
import org.i3.model.User;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public Hello greetWorld(Exchange exchange) {
		Hello hello = new Hello();
		hello.setHeaders(exchange.getIn().getHeaders());
		hello.setGreeting("Hello World");
		hello.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		return hello;
	}

	@Override
	public Hello greetUser(Exchange exchange) {
		Hello hello = new Hello();
		hello.setHeaders(exchange.getIn().getHeaders());
		hello.setGreeting("Hello " + exchange.getIn().getHeader("name"));
		hello.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		return hello;
	}
	
	@Override
	public Hello greetEchoPost(Exchange exchange) {
		Hello hello = new Hello();
		User user = exchange.getIn().getBody(User.class);
		hello.setHeaders(exchange.getIn().getHeaders());
		hello.setGreeting("Hello " + user.getFirst_name() + " " + user.getLast_name());
		hello.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		hello.setUser(user);
		return hello;
	}
}
