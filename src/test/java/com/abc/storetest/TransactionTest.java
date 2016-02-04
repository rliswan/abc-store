package com.abc.storetest;

import org.junit.Test;

import com.abc.account.Account;
import com.abc.product.Apple;
import com.abc.transaction.Transaction;
import com.abc.util.DateUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionTest {
	private static final double DOUBLE_DELTA = 1e-15;
	private static final String dFormat = "yyyyMMdd";

	@Test
	public void transaction() {
		Transaction t = new Transaction(new Apple(), Account.ADD);
		assertTrue(t instanceof Transaction);
	}

	@Test
	public void transaction_with_date() {
		Transaction t = new Transaction(new Apple(), Account.ADD, "20160125", dFormat);
		assertTrue(t instanceof Transaction);
		assertEquals("20160125", DateUtil.convertFromDateToString(t.getTransactionDate(), dFormat));
		assertEquals(2.0, t.getItem().getPrice(), DOUBLE_DELTA);
	}
}
