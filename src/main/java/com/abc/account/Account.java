package com.abc.account;

import java.util.List;
import com.abc.product.Item;
import com.abc.transaction.Transaction;

public interface Account {
	public static final int GUEST_BUYER = 0;
	public static final int FREQUENT_BUYER = 1;
	public static final int WHOLESALE_BUYER = 2;
	public static final String ADD = "A";
	public static final String REMOVE = "R";

	void add(Item item);

	void add(List<Item> bucket);

	void remove(Item item);

	List<Transaction> getTransactions();

	double sumTransactions();

	int getAccountType();

	public int getTotalItems();
}