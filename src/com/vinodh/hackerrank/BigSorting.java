package com.vinodh.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;

public class BigSorting {

	public static void main(String[] args) {
		String[] total = { "1", "64", "53", "13", "949", "3", "13", "16", "31415926535897932384626433832795", "3", "131603", "1" };
		for (String i : total) {
			System.out.println(i);
		}
		BigInteger[] bigInteger = new BigInteger[total.length];
	 	for (int i = 0; i < total.length; i++) {
			bigInteger[i] =  new BigInteger(total[i]);
		}
		Arrays.sort(bigInteger);
		for (BigInteger i : bigInteger) {
			System.out.println(i);
		}
	}

}
