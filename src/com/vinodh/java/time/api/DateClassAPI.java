package com.vinodh.java.time.api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDate, YearMonth, MonthDay, and Year exclusively used for DATE information without any time/time zone 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class DateClassAPI {

	public static void main(String[] args) {

// LocalDate => Year,Month,Day in ISO Calendar without any time information
		System.out.println(LocalDate.now()); // 2017-02-22
		// I was born on MONDAY :-)
		System.out.println(LocalDate.of(1992, Month.APRIL,20).getDayOfWeek());
		System.out.println(LocalDate.of(1992, 4, 20).getDayOfWeek());
		// What's the 256th day in 1992 ??
		System.out.println(LocalDate.ofYearDay(1992, 256));
		// Calculate number of days from 1970
		System.out.println(LocalDate.ofEpochDay(1200));
 		System.out.println(LocalDate.now().toEpochDay());
		// check leap year or not
		System.out.println(LocalDate.now().isLeapYear());
		System.out.println(LocalDate.ofEpochDay(1200).isLeapYear());
		// same day of some year/month
		System.out.println(LocalDate.now().withYear(2015).getDayOfWeek());
		System.out.println(LocalDate.now().withMonth(3));
		//What is the Date of Next Sunday
		System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
		
// YearMonth ==> Month of a Specific Year
		System.out.println(YearMonth.now()); //2017-02
		System.out.println(YearMonth.now().lengthOfMonth());
		System.out.println(YearMonth.now().isLeapYear()); 
		System.out.println(YearMonth.of(2017, 12));
		System.out.println(YearMonth.now().getMonthValue());
	
// MonthDay ==> Day of a Specific Month
		System.out.println(MonthDay.now());//--02-22
		System.out.println(MonthDay.now().getDayOfMonth());
		System.out.println(MonthDay.of(1, 12));
		System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(2015));
		System.out.println(MonthDay.now().getMonthValue());
// Year ==> Date based on Year
 		System.out.println(Year.now()); // 2017
		System.out.println(Year.isLeap(2000));
		System.out.println(Year.of(2010));
		System.out.println(Year.MIN_VALUE);
		System.out.println(Year.MAX_VALUE);
		System.out.println(Year.of(4000).isLeap());
		System.out.println(Year.of(2017).isAfter(Year.of(1200)));
	}

}
