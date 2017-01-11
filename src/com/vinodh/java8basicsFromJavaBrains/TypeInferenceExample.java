package com.vinodh.java8basicsFromJavaBrains;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLambda myLambda = s->s.length();
		System.out.println(myLambda.getLength("Vinodh Kumar Thimmisetty"));
 
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}

}
