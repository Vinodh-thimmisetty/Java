package com.vinodh.java8basicsFromJavaBrains;

@FunctionalInterface
public interface Greeting {
	public void perform();

	public default void another() {

	}

	public static void other() {

	}
}
