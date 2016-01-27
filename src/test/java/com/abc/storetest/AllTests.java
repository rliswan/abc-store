package com.abc.storetest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, CustomerTest.class, DateUtilTest.class, ShoppingCartTest.class, StoreTest.class,
		TransactionTest.class })
public class AllTests {

}
