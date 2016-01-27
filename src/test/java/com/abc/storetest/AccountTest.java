package com.abc.storetest;

import org.junit.Test;

import com.abc.account.Account;
import com.abc.account.FrequentBuyerAccount;
import com.abc.customer.Customer;
import com.abc.product.Apple;
import com.abc.product.Banana;
import com.abc.product.Item;
import com.abc.product.Lemon;
import com.abc.product.Orange;
import com.abc.product.Peach;
import com.abc.store.Store;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class AccountTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test
	public void totalCost() {
		Store store = new Store();
		Account fbuyer = new FrequentBuyerAccount();
		Customer bill = new Customer("Bill").openAccount(fbuyer);
		store.addCustomer(bill);
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		assertEquals(7.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void totalWithRemoveCost() {
		Store store = new Store();
		Account fbuyer = new FrequentBuyerAccount();
		Customer bill = new Customer("Bill").openAccount(fbuyer);
		store.addCustomer(bill);
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.remove(new Apple());
		fbuyer.add(new Banana());
		assertEquals(5.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void totalCostWithBucketList() {
		Store store = new Store();
		ArrayList<Item> bucket = new ArrayList<Item>();
		Account fbuyer = new FrequentBuyerAccount();
		Customer bill = new Customer("Bill").openAccount(fbuyer);
		store.addCustomer(bill);
		bucket.add(new Apple());
		bucket.add(new Banana());
		bucket.add(new Lemon());
		bucket.add(new Orange());
		bucket.add(new Peach());
		fbuyer.add(bucket);
		assertEquals(15.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

}
