package com.vinodh.java.time.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Human Based Times(Hours,Minutes,Seconds,NanoSeconds) without Time Zones
 *  LocalTime (ONLY time), LocalDateTime(Date + Time) 
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class DateAndTimeClassAPI {

	public static void main(String[] args) {
 
// LocalTime(This does not store time zone or daylight saving time information.)
		
		System.out.println(LocalTime.now()); //20:21:08.597
		System.out.println(LocalTime.MAX); //23:59:59.999999999
		System.out.println(LocalTime.MIN); //00:00
		System.out.println(LocalTime.MIDNIGHT); //00:00
		System.out.println(LocalTime.NOON); // 12:00
		System.out.println(LocalTime.of(15, 15));
		System.out.println(LocalTime.now().getHour());
		
// LocalDateTime 		
		System.out.println(LocalDateTime.now()); //2017-02-22T20:26:00.626
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println(LocalDateTime.now().minusDays(45));
		System.out.println(LocalDateTime.now().getChronology());
		System.out.println(LocalDateTime.now().getDayOfWeek());
	}

}
