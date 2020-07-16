package org.i3.service;

import org.apache.camel.Exchange;
import org.i3.model.Hello;

public interface HelloService {

	Hello greeting(Exchange exchange);
}
