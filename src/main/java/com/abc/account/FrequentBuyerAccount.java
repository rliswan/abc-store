package com.abc.account;

import java.util.ArrayList;
import com.abc.transaction.Transaction;

public class FrequentBuyerAccount extends AbstractAccount {

	public FrequentBuyerAccount() {
		this.transactions = new ArrayList<Transaction>();
	}

	public int getAccountType() {
		return FREQUENT_BUYER;
	}

}
