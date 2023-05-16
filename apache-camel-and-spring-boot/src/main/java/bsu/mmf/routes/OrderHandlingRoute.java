package bsu.mmf.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import bsu.mmf.services.PriceAggregation;

@Component
public class OrderHandlingRoute   extends RouteBuilder {
// определяет маршрут для Apache Camel
	@Autowired
	private PriceAggregation priceAggregation;

	@Override
	public void configure() throws Exception {
		from("direct:fetchProcess") //эндпоинт "direct:fetchProcess"
		.split(body(), priceAggregation).parallelProcessing() //разделяет входящее сообщение на отдельные элементы
		.to("bean:pricingService?method=calculatePrice") //вызывает метод "calculatePrice" класса "PricingService"
		.end();//результат передается на выходной эндпоинт
	}
}
