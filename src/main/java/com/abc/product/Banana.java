package com.abc.product;

import java.util.ArrayList;

import com.abc.transaction.Transaction;

public class Banana extends AbstractItem {
	private static final double PRICE = 1.00;

	public Banana() {
		this.transactions = new ArrayList<Transaction>();
	}

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return BANANA;
	}

}
