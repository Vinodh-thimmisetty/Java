package com.vinodh.mustlearn.javaconcepts;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internalization {

	public static void main(String[] args) {
		ResourceBundle us = ResourceBundle.getBundle("com//vinodh//mustlearn//javaconcepts//message", Locale.US);
		ResourceBundle fr = ResourceBundle.getBundle("com//vinodh//mustlearn//javaconcepts//message", Locale.FRANCE);
		ResourceBundle vinodh = ResourceBundle.getBundle("com//vinodh//mustlearn//javaconcepts//message",
				new Locale("en", "IN"));

		System.out.println(us.getString("CountryName"));
		System.out.println(fr.getString("CountryName"));
		System.out.println(vinodh.getString("CountryName"));
	}
}
