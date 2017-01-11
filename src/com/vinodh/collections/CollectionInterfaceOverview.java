package com.vinodh.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Structure : Collection 
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class CollectionInterfaceOverview {

	public static void main(String[] args) { 
		
		// Traversing collection
		// Primitive Array List
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Vinodh");
		arrayList.add("Kranthi");
		arrayList.add("Gopal");
		arrayList.add("Pavan");
		arrayList.add("Janani");
		arrayList.add("Sireesha");
		arrayList.add("Durga");
		arrayList.add("Haritha");
		arrayList.add("Bavya");

		//1. Aggregate Operation ==> JAVA-8
		 
		arrayList.stream().forEach(e->System.out.println(e));
	}

}
