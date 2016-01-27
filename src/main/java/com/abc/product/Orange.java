package com.abc.product;

import java.util.ArrayList;

import com.abc.transaction.Transaction;

public class Orange extends AbstractItem {
	private static final double PRICE = 3.00;

	public Orange() {
		this.transactions = new ArrayList<Transaction>();
	}

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return ORANGE;
	}
}
