package bsu.mmf.services;


import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bsu.mmf.models.Order;
import bsu.mmf.models.OrderLine;

@Component
public class PriceAggregation implements AggregationStrategy{
	
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		OrderLine newBody = newExchange.getIn().getBody(OrderLine.class);
        if (oldExchange == null) {
            Order order = new Order();
            order.setOrderPrice(newBody.getPrice());
            order.addOrderLine(newBody);
            newExchange.getIn().setBody(order, Order.class);
            return newExchange;
        }
        OrderLine newOrderLine = newExchange.getIn().getBody(OrderLine.class);
        Order order = oldExchange.getIn().getBody(Order.class);
        order.setOrderPrice(order.getOrderPrice() + newOrderLine.getPrice());
        order.addOrderLine(newOrderLine);
        oldExchange.getIn().setBody(order);
        
        return oldExchange;
	}

}
