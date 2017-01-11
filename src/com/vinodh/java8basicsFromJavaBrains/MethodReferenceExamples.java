package com.vinodh.java8basicsFromJavaBrains;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExamples {
	public static void main(String[] args) {
Thread thread = new Thread(()->print());
thread.start();
// Method References
Thread thr = new Thread(MethodReferenceExamples::printMessage);
thr.start();
	}
	 
	public static void printMessage(){
		System.out.println("Hello Method references");
	}
	
	public static void print(){
		System.out.println("Hello Lamdas");
	}
	
   public static void printOne(Predicate<Integer> c){ 
	    c.test(1);
		System.out.println("One argument");
	}

}
