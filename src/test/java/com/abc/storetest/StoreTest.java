package com.abc.storetest;

import org.junit.Test;
import com.abc.account.FrequentBuyerAccount;
import com.abc.account.GuestAccount;
import com.abc.account.WholesaleBuyerAccount;
import com.abc.customer.Customer;
import com.abc.product.Apple;
import com.abc.store.Store;

import static org.junit.Assert.assertEquals;

public class StoreTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test
	public void customerSummary() {
		Store store = new Store();
		Customer john = new Customer("John");
		john.openAccount(new FrequentBuyerAccount());
		store.addCustomer(john);
		assertEquals("Customer Summary\n - John (1 account)", store.customerSummary());
	}

	@Test
	public void frequentBuyerAccount() {
		Store store = new Store();
		FrequentBuyerAccount fbuyer = new FrequentBuyerAccount();
		Customer bill = new Customer("Bill").openAccount(fbuyer);
		store.addCustomer(bill);
		fbuyer.add(new Apple());
		assertEquals(2.00, store.totalPurchase(), DOUBLE_DELTA);
	}

	@Test
	public void guestBuyerAccount() {
		Store store = new Store();
		GuestAccount buyer = new GuestAccount();
		Customer bill = new Customer("Bill").openAccount(buyer);
		store.addCustomer(bill);
		buyer.add(new Apple());
		assertEquals(2.00, store.totalPurchase(), DOUBLE_DELTA);
	}

	@Test
	public void wholeSaleBuyerAccount() {
		Store store = new Store();
		WholesaleBuyerAccount buyer = new WholesaleBuyerAccount();
		Customer bill = new Customer("Bill").openAccount(buyer);
		store.addCustomer(bill);
		buyer.add(new Apple());
		assertEquals(2.00, store.totalPurchase(), DOUBLE_DELTA);
	}

}
