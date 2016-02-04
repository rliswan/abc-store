package com.abc.account;

import java.util.List;
import com.abc.product.Item;
import com.abc.transaction.Transaction;

public abstract class AbstractAccount implements Account {

	public static final String dFormat = "yyyyMMdd";
	protected List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
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

	public void remove(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else if (!checkIfItemExistInTransaction(item)) {
			throw new IllegalArgumentException("Can not remove item as it is not in the card");
		} else {
			transactions.remove(new Transaction(item, Account.REMOVE));
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

	public int getTotalItems() {
		return transactions.size();
	}

}