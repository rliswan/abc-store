package com.abc.product;

public class Lemon implements Item {
	private static final double PRICE = 4.00;

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return LEMON;
	}
}
