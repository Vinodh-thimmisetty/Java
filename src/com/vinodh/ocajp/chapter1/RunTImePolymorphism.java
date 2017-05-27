package com.vinodh.ocajp.chapter1;

public class RunTImePolymorphism {
	public static void main(String[] args) {

		ParentClass parent = new ParentClass();
		parent.area();
		parent.length();
		// Compile Error, as test() and yoo() are sub class specific
		// parent.test();
		// parent.yoo();

		SubClass1 subClass1 = new SubClass1();
		subClass1.area();
		subClass1.length();
		subClass1.test();

		SubClass2 subClass2 = new SubClass2();
		subClass2.area();
		subClass2.length();
		subClass2.yoo();

		ParentClass class1 = new SubClass1();
		class1.area();
		class1.length();
		// Compile Error, Eventhough test() is defined for Sub class-1
		// Reference is parent class which doesn't have test() method
		// class1.test();

		ParentClass class2 = new SubClass2();
		class2.area();
		class2.length();
		// Compile Error, Eventhough yoo() is defined for Sub class-2
		// Reference is parent class which doesn't have yoo() method
		// class2.yoo();
	}
}

class ParentClass {
	public void area() {
		System.out.println("super class area");
	}

	public void length() {
		System.out.println("super class length");
	}
}

class SubClass1 extends ParentClass {

	/**
	 * Override method
	 * 
	 */
	public void area() {
		System.out.println("sub class-1 area");
	}

	public void test() {
		System.out.println("sub class-1 method");
	}
}

class SubClass2 extends ParentClass {

	/**
	 * Override method
	 * 
	 */
	public void area() {
		System.out.println("Sub class-2 area");
	}

	public void yoo() {
		System.out.println("sub class-2 specific method");
	}

}
