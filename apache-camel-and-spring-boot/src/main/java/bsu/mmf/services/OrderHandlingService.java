package bsu.mmf.services;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bsu.mmf.models.Order;
import bsu.mmf.models.OrderLine;

@Service
public class OrderHandlingService {
	
	@Autowired
	private ProducerTemplate producerTemplate;
	
	public Order process(final List<OrderLine> orderLines) {
		Order order = producerTemplate.requestBody(
                "direct:processOrder", orderLines, Order.class);
		
		return order;
	}

}
