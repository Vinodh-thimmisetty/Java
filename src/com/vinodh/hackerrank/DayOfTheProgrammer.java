package com.vinodh.hackerrank;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 
 * Find the 256th day of given year Calendars(Julian(1700-1917) -
 * Gregorian(>1918 - 2700)) During 1918, Jan31st -Feb 14th (13 days are skipped)
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class DayOfTheProgrammer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int y = scanner.nextInt();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		LocalDate date;
		switch (y) {
		case 1918:
			date = LocalDate.ofYearDay(1918, 269);
			break;
		default:
			boolean isLeap = false;
			 if(Year.of(y).isLeap()){
				 isLeap = true;
			}
			date = LocalDate.ofYearDay(y, 256);
			if (y <= 1917) {
				if (isLeap == false && y % 4 == 0) {
				date.plusDays(1);
				}  
			}
			break;
		}

		System.out.println(formatter.format(date));
		scanner.close();
	}

}
