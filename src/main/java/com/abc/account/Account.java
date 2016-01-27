package com.abc.account;

import java.util.Date;
import java.util.List;

import com.abc.product.Item;
import com.abc.transaction.Transaction;

public interface Account {
	public static final int GUEST_BUYER = 0;
	public static final int FREQUENT_BUYER = 1;
	public static final int WHOLESALE_BUYER = 2;
	public static final String ADD = "A";
	public static final String REMOVE = "R";

	// add with current date if no date is passed.
	void add(Item item);

	void add(Item item, String dateString);

	void add(List<Item> bucket);

	// remove with current date if no date is passed.
	void remove(Item item);

	void remove(Item item, String dateString);

	List<Transaction> getTransactions();

	void setTransactions(List<Transaction> transactions);

	double sumTransactions();

	double getTransactionAmount(Date date);

	List<Transaction> getTransactions(Date date);

	int getAccountType();

	public int getTotalItems();
}