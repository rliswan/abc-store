package com.abc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String dFormat = "yyyyMMdd";

	public static int compareDate(Date date1, Date date2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat);
		int compareIndicator = -1;
		Date compareDate1;
		Date compareDate2;
		try {// doing this to get rid of the time
			compareDate1 = dateFormat.parse(dateFormat.format(date1));
			compareDate2 = dateFormat.parse(dateFormat.format(date2));
			compareIndicator = compareDate1.compareTo(compareDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compareIndicator;
	}

	public static Date convertfromStringToDate(String dateString, String dFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat);
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;
	}

	public static String convertFromDateToString(Date date, String dFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat);
		return dateFormat.format(date).trim();
	}

}
