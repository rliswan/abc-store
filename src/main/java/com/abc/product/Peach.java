package com.abc.product;

public class Peach implements Item {
	private static final double PRICE = 5.00;

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return PEACH;
	}
}
