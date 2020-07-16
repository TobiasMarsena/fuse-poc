package org.i3.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class TransformRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		XmlJsonDataFormat xmlJson = new XmlJsonDataFormat();
		
		from("direct:proxyXml")
			.marshal(xmlJson)
		;
		
		from("direct:proxyJson")
			.unmarshal(xmlJson)
		;
	}
}
