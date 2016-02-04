package com.abc.product;

public class Orange implements Item {
	private static final double PRICE = 3.00;


	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return ORANGE;
	}
}
