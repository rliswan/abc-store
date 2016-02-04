package com.abc.storetest;

import org.junit.Test;

import com.abc.util.DateProvider;
import com.abc.util.DateUtil;

import static org.junit.Assert.assertEquals;

import java.util.Date;

public class DateUtilTest {
	private static final String dFormat = "yyyyMMdd";

	@Test
	public void compareDateTest() {
		assertEquals(0, DateUtil.compareDate(DateProvider.getInstance().now(), DateProvider.getInstance().now()));
	}

	@Test
	public void convertfromStringToDateTest() {
		Date date = DateUtil.convertfromStringToDate("20160116", dFormat);
		assertEquals("20160116", DateUtil.convertFromDateToString(date, dFormat));
	}

	@Test
	public void convertFromDateToStringTest() {
		String dateString = DateUtil.convertFromDateToString(DateUtil.convertfromStringToDate("20160116", dFormat),
				dFormat);
		assertEquals("20160116", dateString);
	}

}
