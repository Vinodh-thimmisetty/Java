package com.vinodh.ocajp.chapter1;

/**
 * public Class, accessible from anywhere
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class AccessModifiers {

	/**
	 * public method, accessible from anywhere(class must be public too)
	 * 
	 */
	public void print() {
		System.out.println("I am public method");
	}

	/**
	 * protected method, accessible from same package + subclass package
	 * 
	 */
	protected void print1() {
		System.out.println("I am protected method");
	}

	/**
	 * package-private(default) method, accessible within package
	 * 
	 */
	void print3() {
		System.out.println("I am default method");
	}

	/**
	 * print4 method, accessible within the Class
	 * 
	 */
	private void print4() {
		System.out.println("I am private method");
	}
}

/**
 * 
 * Default Class, which can be visible in Same Package
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
class Shape {
	/**
	 * protected instance variable, which can be visible in same package or
	 * different package which extends this class(if class was public)
	 */
	protected int color;

}

class Circle extends Shape {
	/**
	 * private, which can visible only inside the same class
	 */
	private int radius;

	/**
	 * public method, which can accessible from anywhere(if class is public)
	 */
	public void area() {
		System.out.println(Math.PI * radius * radius);
	}

	/**
	 * default method, which can be visible in same package
	 */
	void fillColor() {
		System.out.println("color from the shape class:" + color);
	}
}

class Circles {
	Circle circle = new Circle();

	void getArea() {
		circle.area();
		circle.fillColor();
	}
}