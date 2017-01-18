package com.vinodh.javaBasicsFromOracle;

public class JavaLangPackage implements Cloneable {

	@Override
	public void finalize() {

	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		JavaLangPackage java = new JavaLangPackage();

		/**
		 * java.lang.Object :: It is the root of the class hierarchy. Every
		 * class has Object as a superclass. All objects, including arrays,
		 * implement the methods of this class.
		 * 
		 */
		Dog d = new Dog();
		System.out.println("dog reference-->" + d);

		System.out.println("dog getclass -->" + d.getClass());

		System.out.println("dog hashcode -->" + d.hashCode());

		System.out.println("dog toString--->" + d.toString());

		// "Object copy by cloning
		System.out.println("object cloning--->" + (JavaLangPackage) java.clone());

		// waiting & notifying the object
/*
		java.wait();
		java.notify();
 		java.wait(100);// milliseconds
		java.notifyAll();
 		java.wait(200, 2); // Max time in miliseconds, additional time in nano
							// seconds 0-999999
		java.notify();
*/
		// overriding the Finalyzing the object, before garbage collector
		java.finalize();

		/**
		 * java.lang.Math :: The class Math contains methods for performing
		 * basic numeric operations such as the elementary exponential,
		 * logarithm, square root, and trigonometric functions.
		 * 
		 * 
		 */
		
		System.out.println("value of PI--->"+Math.PI+"---value of e --->"+Math.E);
		
		System.out.println("max --->"+Math.max(2, 45)+"--Min --->"+Math.min(2, 56));// similar for int,float,long

		System.out.println("Random b/w 0.0 and 1.0--->"+Math.random());
		System.out.println("Rounding off ---->"+Math.round(2.65445)); // similar for float
		System.out.println("Absolute value in double -->"+Math.abs(14.24500)); // similar for int,float,long
		System.out.println("units in last place (ulps) ---->"+Math.ulp(2.36577)); // similar to float
		
		System.out.println("arc cosine , cos inverse-->"+Math.acos(0.24)); // similar for sin/tan inverse
		
		System.out.println("return sum of arguments -->"+Math.addExact(1, 2)+"--multiply --->"+Math.multiplyExact(2, 3)+"--subtract  --->"+Math.subtractExact(4, 3)+"----negation -->"+Math.negateExact(3)); // similar for long
		
		System.out.println("a power b --->"+Math.pow(2, 3)+"square root ---> "+Math.sqrt(2)+"--cube root--->"+Math.cbrt(2));
		
		System.out.println("exponential --->"+Math.exp(2.5)+"---Returns e(pow x) -1.--->"+Math.expm1(2.5));
		
		System.out.println("logarithms base e--->"+Math.log(3)+"---base 10--->"+Math.log10(50));  
		System.out.println("Trignometric --->"+Math.cos(0.5)); // similar for sin and tan
		
		System.out.println("Hyperbolic --->"+Math.cosh(0.5));  // similar for sin and tan
		
		System.out.println("hypotenus of right truangle a square + b sqaure--->"+Math.hypot(2, 3));
		
		System.out.println(" ceil -->"+Math.ceil(1.4569823)+"-- Floor ---->"+Math.floor(1.4569823));
		
		System.out.println("return the arguement decremet by one --->"+Math.decrementExact(5)); // similar for long 
		
		/**
		 * java.lang.String :: The String class represents character strings.
		 * 
		 */

	System.out.println("compare lexicographically --->"+new String("abc").compareTo("abc"));
	 
		
		/**
		 * java.lang.StringBuffer :: A thread-safe, mutable sequence of
		 * characters.
		 * 
		 */

		/**
		 * java.lang.StringBuilder :: A mutable sequence of characters.
		 * 
		 * 
		 * 
		 */

		/**
		 * java.lang.System :: The System class contains several useful class
		 * fields and methods.
		 * 
		 */

		/**
		 * java.lang.Thread :: A thread is a thread of execution in a program.
		 * 
		 * 
		 * 
		 */

	}

}
