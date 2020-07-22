package org.i3.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class TransformRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		XmlJsonDataFormat xmlJson = new XmlJsonDataFormat();
		
		from("netty-http:http://0.0.0.0:8080/proxy")
			.choice()
				.when().simple("${header.CamelHttpMethod} != 'GET' && ${header.Content-Type} == 'application/xml'")
					.marshal(xmlJson)
				.when().simple("${header.CamelHttpMethod} != 'GET' && ${header.Content-Type} == 'application/json'")
					.unmarshal(xmlJson)
			.end()
		;
	}
}
