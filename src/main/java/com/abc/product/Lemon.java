package com.abc.product;

import java.util.ArrayList;

import com.abc.transaction.Transaction;

public class Lemon extends AbstractItem {
	private static final double PRICE = 4.00;

	public Lemon() {
		this.transactions = new ArrayList<Transaction>();
	}

	public double getPrice() {
		return PRICE;
	}

	public int getItemName() {
		return LEMON;
	}
}
