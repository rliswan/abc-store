package com.abc.account;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.abc.product.Item;
import com.abc.transaction.Transaction;

import com.abc.util.DateUtil;

public abstract class AbstractAccount implements Account {

	public static final String dFormat = "yyyyMMdd";
	protected List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void add(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else {
			transactions.add(new Transaction(item, Account.ADD));
		}
	}

	public void add(List<Item> bucket) {
		if (bucket == null) {
			throw new IllegalArgumentException("item must not be null");
		} else {
			for (Item item : bucket)
				transactions.add(new Transaction(item, Account.ADD));
		}
	}

	public void add(Item item, String dateString) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else {
			transactions.add(new Transaction(item, Account.ADD, dateString, dFormat));
		}
	}

	public void remove(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else if (!checkIfItemExistInTransaction(item)) {
			throw new IllegalArgumentException("Can not remove item as it is not in the card");
		} else {
			transactions.remove(new Transaction(item, Account.REMOVE));
		}
	}

	public void remove(Item item, String dateString) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else if (!checkIfItemExistInTransaction(item)) {
			throw new IllegalArgumentException(
					"amount must be less than or equal to the balance: " + sumTransactions());
		} else {
			transactions.remove(new Transaction(item, Account.REMOVE, dateString, dFormat));
		}
	}

	public double sumTransactions() {
		double amount = 0.0;
		for (Transaction t : transactions)
			amount += t.getItem().getPrice();
		return amount;
	}

	private boolean checkIfItemExistInTransaction(Item item) {
		for (Transaction t : transactions) {
			if (t.getItem().getItemName() == item.getItemName()) {
				return true;
			}
		}
		return false;
	}

	public double getTransactionAmount(Date date) {
		double amount = 0.0;
		for (Transaction t : transactions) {
			if (DateUtil.compareDate(t.getTransactionDate(), date) == 0) {
				amount = t.getItem().getPrice();
			}
		}
		return amount;
	}

	public List<Transaction> getTransactions(Date date) {
		List<Transaction> trans = new ArrayList<Transaction>();
		for (Transaction t : transactions) {
			if (DateUtil.compareDate(t.getTransactionDate(), date) == 0)
				trans.add(t);
		}
		return trans;
	}

	public int getTotalItems() {
		return transactions.size();
	}

}