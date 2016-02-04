package com.abc.product;

public interface Item {
	public static final int BANANA = 0;
	public static final int APPLE = 1;
	public static final int ORANGE = 2;
	public static final int LEMON = 3;
	public static final int PEACH = 4;

	int getItemName();

	double getPrice();
}