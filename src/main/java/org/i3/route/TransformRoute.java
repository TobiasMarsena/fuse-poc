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
		
		from("netty-http:http://0.0.0.0:8080?matchOnUriPrefix=true")
			.choice()
				.when().simple("${header.CamelHttpMethod} != 'GET' && ${header.Content-Type} == 'application/xml'")
					.marshal(xmlJson)
				.when().simple("${header.CamelHttpMethod} != 'GET' && ${header.Content-Type} == 'application/json'")
					.unmarshal(xmlJson)
				.when().simple("${header.CamelHttpMethod} == 'GET' && "
						+ "${header.CamelHttpPath} == '/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zsd_hrgol00005/320/zws_hrgol00005/zws_hrgol00005'")
					.removeHeaders("Camel*")
					.setHeader(Exchange.HTTP_METHOD, constant("GET"))
					.setHeader(Exchange.HTTP_QUERY, constant("sap-client=320"))
					.setHeader(Exchange.HTTP_PATH, constant("/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zsd_hrgol00005/320/zws_hrgol00005/zws_hrgol00005"))
					.to("http://hanaerp-ci.taspen.co.id:8500")
					.marshal(xmlJson)
			.end()
		;
	}
}
