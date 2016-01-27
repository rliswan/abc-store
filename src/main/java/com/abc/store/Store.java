package com.abc.store;

import java.util.ArrayList;
import java.util.List;

import com.abc.customer.Customer;

public class Store {
	private List<Customer> customers;

	public Store() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public String customerSummary() {
		String summary = "Customer Summary";
		for (Customer c : customers)
			summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
		return summary;
	}

	private String format(int number, String word) {
		return number + " " + (number == 1 ? word : word + "s");
	}

	public double totalPurchase() {
		double total = 0;
		for (Customer c : customers)
			total += c.getTotalPurchase();
		return total;
	}

	public String getFirstCustomer() {
		try {
			customers = null;
			return customers.get(0).getName();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
}
