package com.abc.product;

import java.util.List;
import com.abc.transaction.Transaction;

public abstract class AbstractItem implements Item {

	public static final String dFormat = "yyyyMMdd";
	public static final int withdrawalDaysRule = 10;
	protected List<Transaction> transactions;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Item item = (Item) obj;
		return (this.getItemName() == item.getItemName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getItemName();
		return result;
	}

}