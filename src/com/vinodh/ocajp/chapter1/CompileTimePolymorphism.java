package com.vinodh.ocajp.chapter1;

public class CompileTimePolymorphism {

	public static void a() {
		System.out.println("NO Argument method");
	}

	public static void a(byte b) {
		System.out.println("byte arg method");
	}

	public static void a(short s) {
		System.out.println("short arg method");
	}

	public static void a(int i) {
		System.out.println("int arg method");
	}

	public static void a(long l) {
		System.out.println("long arg method");
	}

	public static void a(float f) {
		System.out.println("float arg method");
	}

	public static void a(double d) {
		System.out.println("double arg method");
	}

	public static void a(String ss) {
		System.out.println("string arg method");
	}

	public static void a(Object o) {
		System.out.println("object arg method");
	}

	public static void a(int i, long l) {
		System.out.println("int & long arg methods");
	}

	public static void a(long l, int i) {
		System.out.println("long & int arg methods");
	}

	public static void a(int i, float f) {
		System.out.println("int & float arg method");
	}

	public static void main(String[] args) {
		byte b = 9;
		short s = 10;
		int i = 100;
		long l = 1111L;
		float f = 10.34f;
		double d = 433.343;
		String ss = "vinodh";

		// comment each individual method of a(), to result UPCASTING
		a();
		a(b);
		a(s);
		a(i);
		a(l);
		a(f);
		a(d);
		a(ss);
		a(new Integer(1245));
		// Ambiguous if second arg is normal int
		a(1, 2l);
		// Ambiguous if First arg is norma int
		a(12l, 3);
		a(12, 323.43f);

	}
}
