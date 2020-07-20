package org.i3.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class TransformRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		XmlJsonDataFormat xmlJson = new XmlJsonDataFormat();
		
		from("direct:proxy")
			.choice()
				.when().simple("${header.Content-Type} == 'application/xml'")
					.marshal(xmlJson)
				.when().simple("${header.Content-Type} == 'application/json'")
					.unmarshal(xmlJson)
				.otherwise()
					.setBody(simple("Content type must be XML or JSON"))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant("500"))
			.end()
		;
	}
}
