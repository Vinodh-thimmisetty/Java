package com.vinodh.java8basicsFromJavaBrains;

public class HelloWorldGreeting implements Greeting {

	@Override
	public void perform() {
		System.out.println("Hello world concrete Greeting !!");
	}

}
