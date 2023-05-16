package bsu.mmf.services;

import org.springframework.stereotype.Service;

import bsu.mmf.models.OrderLine;

@Service
public class PricingService {
	
	public OrderLine calculatePrice(final OrderLine orderLine ) {
		String category = orderLine.getProduct().getProductCategory();
		if("Telephone".equalsIgnoreCase(category))
		   orderLine.setPrice(300.0);
		else if("Laptop".equalsIgnoreCase(category))
			orderLine.setPrice(55.0);
		else
			orderLine.setPrice(99.0);
		return orderLine;
		
	}

}
