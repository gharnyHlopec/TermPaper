package bsu.mmf.models;

import java.util.ArrayList;
import java.util.List;


public class Order {
	
	private List<OrderLine> orderLines;
	
	private double orderPrice;

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void addOrderLine(OrderLine orderLine) {
		if(orderLines == null) orderLines = new ArrayList<OrderLine>();
		orderLines.add(orderLine);
	}
	
}
