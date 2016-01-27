package com.abc.util;

import java.util.Calendar;
import java.util.Date;

public class DateProvider {
	private volatile static DateProvider instance;

	private DateProvider() {
	}

	public static DateProvider getInstance() {
		if (instance == null) {
			synchronized (DateProvider.class) {
				if (instance == null) {
					instance = new DateProvider();
				}
			}
		}
		return instance;
	}

	public Date now() {
		return Calendar.getInstance().getTime();
	}
}
