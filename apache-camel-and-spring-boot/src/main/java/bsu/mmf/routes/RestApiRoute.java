package bsu.mmf.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import bsu.mmf.models.Order;
import bsu.mmf.services.OrderService;

@Component
public class RestApiRoute  extends RouteBuilder {
	@Autowired
	private Environment env;
	@Override
	public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		restConfiguration()
        .contextPath("/ecommapp")
        .apiProperty("cors", "true")
        .apiContextRouteId("doc-api")
        .port(env.getProperty("server.port", "8080"))
        .bindingMode(RestBindingMode.json);
		
		rest("/order/process")
		.get("/").description("Process order")
		.route().routeId("orders-api")
		.bean(OrderService.class, "generateOrder")	// После получения GET-запрос, вызывается метод "generateOrder" класса "OrderService", чтобы создать новый заказ.
		.to("direct:fetchProcess") 
		.endRest();
		
	}

}
