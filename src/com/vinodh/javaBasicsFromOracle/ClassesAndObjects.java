package com.vinodh.javaBasicsFromOracle;
/**
 * 
 * static block --> static methods --> normal blocks for every constructor
 * 
 * Every reference to static variable will have last value that is assigned to static variable
 * 
 * 
 * @author Vinodh
 *
 */
public class ClassesAndObjects {
	private int vinodh;
	
	private static String jaffa = "pavan";
	
	public ClassesAndObjects(int name){
		super();
		this.vinodh = name;
	}

	public ClassesAndObjects(){
		super();
	}
	static{
		System.out.println("static block 2 in order 1");
	}
	{
		System.out.println("initalizer blocks ---1 in order 1 & shared by all available constructors");
	}
	static{
		System.out.println("static block 1 in order 2");
	}
	{
		System.out.println("initalizer blocks ---2 in order 2 & shared by all available constructors");
	}
	static{
		System.out.println("static variable in initialization block---" +jaffa);
	}
	
	
	public static void main(String[] args) {
		System.out.println("inside main static method");

		System.out.println("static variable ---"+ClassesAndObjects.jaffa);
		 ClassesAndObjects co = new ClassesAndObjects();
		 co.staticMethods();

		 int i = co.test();
		 System.out.println("Value of i===>"+i);

		 ClassesAndObjects andObjects = new ClassesAndObjects(3);
		 System.out.println("instance variable value--"+andObjects.vinodh);
	}
	
	public static void staticMethods(){
		System.out.println("static method ---->");
		System.out.println("static variable  in normal static method---"+ClassesAndObjects.jaffa);
		
	}
	
	public int test(){
		return 2;
	}

}
