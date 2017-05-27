package com.vinodh.ocajp.test;

import com.vinodh.ocajp.chapter1.AccessModifiers;

/**
 * public class, which can access any thing
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class Canvas extends AccessModifiers {

	/**
	 * 
	 * default method, only accessible in own package
	 */
	void getArea() {
		AccessModifiers accessModifiers = new AccessModifiers();

		// public method in super class
		accessModifiers.print();

		// Compile Error is Protected method is called through new AccessModfier
		// accessModifiers.print1();

		// need to call with the Instance which extends the AccessModifier class
		this.print1();
		this.print();
	}

}

