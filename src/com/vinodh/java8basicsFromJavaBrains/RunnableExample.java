package com.vinodh.java8basicsFromJavaBrains;

public class RunnableExample {

	public static void main(String[] args) {
		
		// anonymous inner class
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("inside runnable");	
			}
		});
		
		thread.start();
		
		// Lambdas
		
		Thread lamda = new Thread(()-> System.out.println("lamda thread"));
		lamda.start();
	}

}
