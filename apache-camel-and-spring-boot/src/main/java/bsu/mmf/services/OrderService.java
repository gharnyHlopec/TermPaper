package bsu.mmf.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bsu.mmf.models.Order;
import bsu.mmf.models.OrderLine;
import bsu.mmf.models.Product;

@Service
public class OrderService {
	
	public List<OrderLine> generateOrder() {
		System.out.println("creating products");
		
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		
		OrderLine orderLine = new OrderLine();
		orderLine.setProduct(new Product("iPhone", "Telephone"));
		
		orderLines.add(orderLine);
		
		orderLine = new OrderLine();
		orderLine.setProduct(new Product("MacBook", "Laptop"));
		
		orderLines.add(orderLine);
		return orderLines;
	}	
}
