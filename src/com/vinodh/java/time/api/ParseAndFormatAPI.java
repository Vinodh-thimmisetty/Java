package com.vinodh.java.time.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/***
 * 
 * Parse from String to Date (We don't have any control of how it happens)
 * Format the Date to String (We provide the expected output format)
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class ParseAndFormatAPI {

	public static void main(String[] args) throws ParseException {

// Java 7 way
		Date date = new Date();
		System.out.println(date);
		String s= "11/11/2011";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY");
		// I want to print todays date in above format
		System.out.println(simpleDateFormat.format(new Date()));
		// I want to print the above String s in dd.mm.yyyy format
		System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(s)));
		// For Parsing Dateformatter should match with the String you are parsing i.e, for s the dateformat is dd/MM/YYYY
		// For Formatting, it's your choice
		
// Java 8 way
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
 		String ss= "11/11/2011";
 		DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
 			// I want to print todays date in above format
 			System.out.println(LocalDate.now().format(dateTimeFormatter));
 			// I want to print the above String s in dd.mm.yyyy format
 			System.out.println(DateTimeFormatter.ofPattern("dd.MM.YYYY").format(LocalDate.parse(ss, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
 			
	}

}
