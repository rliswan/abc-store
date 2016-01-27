package com.abc.storetest;

import org.junit.Test;

import com.abc.account.Account;
import com.abc.account.FrequentBuyerAccount;
import com.abc.account.GuestAccount;
import com.abc.account.WholesaleBuyerAccount;
import com.abc.customer.Customer;
import com.abc.product.Apple;
import com.abc.product.Banana;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

	@Test // Test customer statement generation
	public void testApp() {

		Account fAccount = new FrequentBuyerAccount();
		Account wAccount = new WholesaleBuyerAccount();

		Customer henry = new Customer("Henry").openAccount(fAccount).openAccount(wAccount);
		fAccount.add(new Apple());
		wAccount.add(new Banana());
		System.out.println("" + henry.getStatement());
		;

		assertEquals("Statement for Henry\n" + "\n" + "Frequent Buyer Account\n" + "  add $2.00\n" + "Total $2.00\n"
				+ "\n" + "Wholesale Buyer Account\n" + "  add $1.00\n" + "Total $1.00\n" + "\n"
				+ "Total In All Accounts $3.00", henry.getStatement());
	}

	@Test
	public void testOneAccount() {
		Customer oscar = new Customer("Oscar").openAccount(new FrequentBuyerAccount());
		assertEquals(1, oscar.getNumberOfAccounts());
	}

	@Test
	public void testTwoAccount() {
		Customer oscar = new Customer("Oscar").openAccount(new WholesaleBuyerAccount());
		oscar.openAccount(new FrequentBuyerAccount());
		assertEquals(2, oscar.getNumberOfAccounts());
	}

	@Test
	public void testThreeAcounts() {
		Customer oscar = new Customer("Oscar").openAccount(new FrequentBuyerAccount());
		oscar.openAccount(new GuestAccount());
		oscar.openAccount(new WholesaleBuyerAccount());
		assertEquals(3, oscar.getNumberOfAccounts());
	}

}
