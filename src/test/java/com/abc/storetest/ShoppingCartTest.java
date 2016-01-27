package com.abc.storetest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
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

public class ShoppingCartTest {
	private static final double DOUBLE_DELTA = 1e-15;
	Store store;
	Account fbuyer;
	Customer bill;

	@Before
	public void setUp() {
		store = new Store();
		fbuyer = new FrequentBuyerAccount();
		bill = new Customer("Bill").openAccount(fbuyer);
		store.addCustomer(bill);
	}

	@Test
	public void addOneItemToCart() {
		fbuyer.add(new Apple());
		assertEquals(2.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
		assertEquals(1, fbuyer.getTotalItems());

	}

	@Test
	public void addTwoItemsToCart() {
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		assertEquals(3.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
		assertEquals(2, fbuyer.getTotalItems());
	}

	@Test
	public void addThreeItemsToCart() {
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		fbuyer.add(new Peach());
		assertEquals(8.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
		assertEquals(3, fbuyer.getTotalItems());
	}

	@Test
	public void addAnItemTwice() {
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		assertEquals(2, fbuyer.getTotalItems());
	}

	@Test
	public void checkOutOneItem() {
		fbuyer.add(new Apple());
		assertEquals(2.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void checkoutTwoSeparateItems() {
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		assertEquals(3.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void checkoutThreeSeparateItems() {
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		fbuyer.add(new Peach());
		assertEquals(8.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void checkoutTwoSameItems() {
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		assertEquals(4.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void checkoutThreeItems() {
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		fbuyer.add(new Peach());
		assertEquals(8.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test // you can see the price of each item in each of the class itself.
	public void totalCost() {
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Banana());
		assertEquals(7.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void totalCostWithRemoveCost() {
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.add(new Apple());
		fbuyer.remove(new Apple());
		fbuyer.add(new Banana());
		assertEquals(5.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void totalCostWithBucketList() {
		ArrayList<Item> bucket = new ArrayList<Item>();
		bucket.add(new Apple());
		bucket.add(new Banana());
		bucket.add(new Lemon());
		bucket.add(new Orange());
		bucket.add(new Peach());
		fbuyer.add(bucket);
		assertEquals(15.00, fbuyer.sumTransactions(), DOUBLE_DELTA);
	}

}
