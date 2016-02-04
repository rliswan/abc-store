package com.abc.product;

public class Banana implements Item {
	private static final double PRICE = 1.00;

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return BANANA;
	}

}
