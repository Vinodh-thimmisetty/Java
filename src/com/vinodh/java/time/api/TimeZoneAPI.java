package com.vinodh.java.time.api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

/**
 * A time zone is a region of the earth where the same standard time is used.
 * Each time zone is described by an identifier and usually has the format
 * region/city (Asia/Tokyo) and an offset from Greenwich/UTC time. For example,
 * the offset for India is +05:30
 * 
 * ZoneId(Region/City) &&  ZoneOffset(Offset from Greenwich UTC time)
 * ZonedDateTime,OffsetDateTime,OffsetTime
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class TimeZoneAPI {

	public static void main(String[] args) {
		// Machine Readable
		System.out.println(Instant.now()); //2017-02-22T15:39:17.947Z
		System.out.println(Instant.now().toString());
		System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
		
		// Available Time Zones
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		zoneIds.stream().forEach(System.out::println);

		System.out.println(ZoneId.systemDefault()); // Asia/Calcutta
		System.out.println(ZoneOffset.MIN);
		System.out.println(ZoneOffset.MAX);
		System.out.println(ZoneOffset.UTC.getDisplayName(TextStyle.FULL, Locale.getDefault()));
		// Default Locale Offset time
		System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).getOffset());
		
//ZonedDateTime (LocalDateTime ++ ZoneId)
		System.out.println(ZonedDateTime.now());  // 2017-02-22T20:51:59.997+05:30[Asia/Calcutta] 
		System.out.println(ZonedDateTime.now(ZoneId.systemDefault()));
		// DayLight Saving
		System.out.println((ZoneId.systemDefault().getRules().isDaylightSavings(Instant.now())));

//OffsetDateTime (LocalDateTime ++ ZoneOffset)		 
		System.out.println(OffsetDateTime.now()); //2017-02-22T20:59:12.124+05:30
		System.out.println(OffsetDateTime.now(ZoneId.systemDefault()).getHour());
		System.out.println(OffsetDateTime.of(LocalDateTime.now().of(LocalDate.of(2010, Month.FEBRUARY, 14), LocalTime.now()), ZoneOffset.of("+06:30")).getDayOfWeek());
		
// OffsetTime
		System.out.println(OffsetTime.now()); //21:05:31.988+05:30
	
	}

}
