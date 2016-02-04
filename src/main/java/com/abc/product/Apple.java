package com.abc.product;

public class Apple implements Item {
	private static final double PRICE = 2.00;

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return APPLE;
	}

}
