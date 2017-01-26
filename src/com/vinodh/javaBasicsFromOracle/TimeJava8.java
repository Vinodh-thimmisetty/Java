package com.vinodh.javaBasicsFromOracle;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.vinodh.javaBasicsFromOracle.EnumTypes.Day;
/**
 * DATE-TIME API => ISO Calendar :: human Time (Year->Month->Week->Day->Hour->Minute->Second) ++ machineTime called epoch
 *  
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class TimeJava8 {

	public static void main(String[] args) {
		
		// ENUMS
		System.out.println("Day of month-->"+DayOfWeek.SUNDAY.getDisplayName(TextStyle.SHORT, Locale.getDefault()));//monday(1)-sunday(7)
		System.out.println("Day-->"+Day.SUNDAY);
		System.out.println("NUmber of days in Month--->"+Month.FEBRUARY.maxLength());
	 	System.out.println("Month-->"+Month.JUNE.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
	 	System.out.println("Month-->"+Month.JULY.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));

		// LocalDate ==>Exclusive for Date without considering any Time ZONE
		 	LocalDate date = LocalDate.of(1993, Month.APRIL, 20); // Date Of Birth Representations
			DayOfWeek dayOfWeek =date.getDayOfWeek();
			// get next wedensday using Temporal Adjuster
			LocalDate localDate = date.with(TemporalAdjusters.next(dayOfWeek));
			System.out.println("local date-->"+localDate);
			// yearMonth
			YearMonth month = YearMonth.now();
			YearMonth month2 =YearMonth.of(2000, 1); 
			System.out.println("Year using Yearmonth Class-->"+month.getMonth());
	 		System.out.println("Year using Yearmonth Class-->"+month2.getMonth());
	 		System.out.println("Lenght of month using Yearmonth Class-->"+month.lengthOfMonth());	
			// MonthDay
			MonthDay day = MonthDay.now();
			MonthDay day2 =MonthDay.of(1, 3); 	
			System.out.println("MOnthDay classes month-->"+day.getMonth());
			System.out.println("Monthday classes day--->"+day2.getDayOfMonth());
			// Year
			Year year = Year.now();
			System.out.println("is this year leap year ???--->"+year.isLeap());
			System.out.println("is 2048 leap year---->"+Year.of(2048).isLeap());
			 
			
		// LocalTIme ==> deals only with time==> used for human times	
			System.out.println("Local time values---->"+LocalTime.now().getHour() +"--"+LocalTime.MIDNIGHT.getMinute()+"----"+LocalTime.of(23, 55).getSecond());
		//LocalDateTime ==> time+date without time zone	
			System.out.println("LocalDateTime ----->"+LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()));
			System.out.println("plus months"+LocalDateTime.now().plusMonths(3));
			
			
			// Time Zones(Region/city) ++ Offset(Greenwich/UTC time)
			Set<String> set = ZoneId.getAvailableZoneIds();
			set.stream().forEach(System.out::println);
			
			ZoneId id = ZoneId.of(ZoneId.systemDefault().toString());
			ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(id);
			ZoneOffset zoneOffset = zonedDateTime.getOffset();
			System.out.println("zone id -->"+id+"---time at this zone--->"+zonedDateTime+"---offset of this zone--->"+zoneOffset);
			// List all offset timings of all available zones
			Set<String> zones = ZoneId.getAvailableZoneIds();
			List<String> list = new ArrayList<>(zones);
			Collections.sort(list);
			LocalDateTime time = LocalDateTime.now();
			set.stream().forEach(p->{ 
				//System.out.println("zone----->"+p);
				ZoneId zid = ZoneId.of(p);
				ZonedDateTime zondtime = time.atZone(zid);
				//System.out.println("zone time----->"+zondtime);
			 System.out.println("zone--->"+p+"---zoneOffset----->"+zondtime.getOffset());
			});
			
			// Instant classes Machine mtime
			System.out.println(Instant.now());
			System.out.println("min instant--> "+Instant.MIN.getEpochSecond()+"----Max instant-->"+Instant.MAX.getEpochSecond());
			// time between two instants
			System.out.println("until machine time--->"+Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS));
			
			// DateTimeFormatter 
			//DateTimeFormatter formatter =DateTimeFormatter.ofPattern("MM dd YYYY");
			 		
			 //	System.out.println("=-=-=>>>>"+LocalDate.parse("02 14 2011", formatter).format(formatter));
			
			
	// TEMPORAL Package		
			
			
			
			
			/*
		if (java.time.LocalDate.now().atStartOfDay().compareTo(java.time.LocalDate.now().atStartOfDay()) == 0) {
			System.out.println("Hurray===");
		}
		System.out.println(java.time.chrono.ThaiBuddhistEra.BEFORE_BE.getValue());
		System.out.println(new Date());
		System.out.println(java.time.format.SignStyle.EXCEEDS_PAD);
		System.out.println(java.time.zone.ZoneRulesProvider.refresh());
		*/
		 
	}

}
