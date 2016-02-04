package com.abc.customer;

import java.util.ArrayList;
import java.util.List;

import com.abc.account.Account;
import com.abc.transaction.Transaction;

import static java.lang.Math.abs;

public class Customer {
	private String name;
	private List<Account> accounts;

	public Customer(String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public Customer openAccount(Account account) {
		accounts.add(account);
		return this;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}

	public String getStatement() {
		String statement = null;
		statement = "Statement for " + name + "\n";
		double total = 0.0;
		for (Account a : accounts) {
			statement += "\n" + statementForAccount(a) + "\n";
			total += a.sumTransactions();
		}
		statement += "\nTotal In All Accounts " + toDollars(total);
		return statement;
	}

	private String statementForAccount(Account a) {
		String s = "";

		// Translate to pretty account type
		switch (a.getAccountType()) {
		case Account.GUEST_BUYER:
			s += "Guest Buyer Account\n";
			break;
		case Account.FREQUENT_BUYER:
			s += "Frequent Buyer Account\n";
			break;
		case Account.WHOLESALE_BUYER:
			s += "Wholesale Buyer Account\n";
			break;
		}

		// Now total up all the transactions
		double total = 0.0;
		for (Transaction t : a.getTransactions()) {
			s += "  " + (t.getItem().getPrice() < 0 ? "remove" : "add") + " " + toDollars(t.getItem().getPrice())
					+ "\n";
			total += t.getItem().getPrice();
		}
		s += "Total " + toDollars(total);
		return s;
	}

	public double getTotalPurchase() {
		double total = 0.0;

		for (Account a : accounts) {
			total += a.sumTransactions();
		}
		return total;
	}

	private String toDollars(double d) {
		return String.format("$%,.2f", abs(d));
	}
}
