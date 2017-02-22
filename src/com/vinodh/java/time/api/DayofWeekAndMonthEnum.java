package com.vinodh.java.time.api;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayofWeekAndMonthEnum {

	public static void main(String[] args) {

 // Day of a Week ENUMS
		System.out.println(DayOfWeek.SUNDAY);
		System.out.println(DayOfWeek.SUNDAY.plus(1));
		  // Starts with Monday (1-7) and "of" will create new Instance
		System.out.println(DayOfWeek.of(2)); 
		System.out.println(DayOfWeek.THURSDAY.ordinal());
		System.out.println(DayOfWeek.SUNDAY.getValue());
		DayOfWeek[] dayOfWeeks = DayOfWeek.values();
		for (DayOfWeek dayOfWeek : dayOfWeeks) {
			System.out.println("Today is --> " + dayOfWeek);
		}
		System.out.println(DayOfWeek.FRIDAY.compareTo(DayOfWeek.SATURDAY));
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
		// Used in Different Languages where output format is different for e.g: Narrow stand alone will print 4 for Thursday
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()));
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.NARROW_STANDALONE, Locale.getDefault()));
		System.out.println(DayOfWeek.THURSDAY.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault()));
 
// Day of a Month ENUMS
		System.out.println(Month.JANUARY);// (1-12)
		System.out.println(Month.FEBRUARY.maxLength());
		System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, Locale.FRANCE));
		System.out.println(Month.JULY.getValue());
		System.out.println(Month.DECEMBER.firstMonthOfQuarter()); // 4 quarters in a year
		System.out.println(Month.SEPTEMBER.ordinal());
		Month[] months = Month.values();
		for (Month month : months) {
			System.out.println("Month is -->"+month);
		}
		System.out.println(Month.FEBRUARY.length(false));
		System.out.println(Month.OCTOBER.firstDayOfYear(true));
		System.out.println(Month.JUNE.plus(54));
		
	}

}
