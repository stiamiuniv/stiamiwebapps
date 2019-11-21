package com.stiamiwebapps.stiami.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtility {
	
	public String getFormatedDate(String toFormatDate,String fromFormatDate,  String date) {
		SimpleDateFormat toFormat = new SimpleDateFormat(toFormatDate);
		SimpleDateFormat formatter = new SimpleDateFormat(fromFormatDate);
		Date parsedDate;
		try {
			parsedDate = formatter.parse(date);
			return toFormat.format(parsedDate);
		} catch (ParseException e) {
			return e.getMessage().toString();
		}
	}
	
	public String getFormatedDate(int timeInMillis,  String toFormatDate) {
		Date date = new Date(timeInMillis);
		SimpleDateFormat formatter = new SimpleDateFormat(toFormatDate);
		return formatter.format(date);
	}
	
	public String getFormatedDate(Date date,  String toFormatDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(toFormatDate);
		return formatter.format(date);
	}
	
	public String getCurrentDate(String toFormatDate) {
		SimpleDateFormat toFormat = new SimpleDateFormat(toFormatDate);
		Date date = new Date();
		return toFormat.format(date);
	}
	
	public int getDiffDays(String fromDate, String toDate, String formatDate) {
		int diff = 0;
		SimpleDateFormat toFormat = new SimpleDateFormat(formatDate);
		try {
			Date from = toFormat.parse(fromDate);
			Date to = toFormat.parse(toDate);
			
			long secondsInMilli = 1000;
		    long minutesInMilli = secondsInMilli * 60;
		    long hoursInMilli = minutesInMilli * 60;
		    long daysInMilli = hoursInMilli * 24;

			long different = to.getTime() - from.getTime();
			diff = (int)(different / daysInMilli);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diff;
	}
}
