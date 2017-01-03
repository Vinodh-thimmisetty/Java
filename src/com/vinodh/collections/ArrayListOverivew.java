package com.vinodh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * 
 * Data Structure : Arraylist --> Resizble or Growable ARRAY implemention
 * Insertion Order : Preserved
 * Duplicates : Allowed
 * Allows any type of objects [Homogenous or Heterogenous]
 * NULL insertions ?? check out the code
 * Synchoronized : NO !!
 * Support Generics
 * Support Iterators & forEach & Streams(java 8) 
 * 		[[ elements in the list can be added/removed with help of Iterators but not with forEach ]] 	
 * Algorithm Features:
 *  Searching: Easy based on Index(Random access)
 *  Deletion : @ end is easy
 *  Insertion : @ end is easy
 *  Sorting : Can be sort with help of Collections utility class
 * @author Vinodh Kumar Thimmisetty
 *
 */

public class ArrayListOverivew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 
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

		System.out.println("-------Primitive Iterator ----");
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		System.out.println("------- Primitive forEach ----");
		for (String string : arrayList) {
			System.out.println(string);
		}

		// Object Array List
		ArrayList<Person> persons = new ArrayList<>();
		ArrayList<Person> girls = new ArrayList<>();

		Person p11 = new Person(11, "vinodh", 123);
		Person p21 = new Person(21, "Kranthi", 2123);
		Person p31 = new Person(31, "Gopal", 3123);
		Person p41 = new Person(41, "Pavan", 4123);
		Person p51 = new Person(51, "Janani", 5123);//
		Person p61 = new Person(61, "Sireesha", 6123);//
		Person p71 = new Person(71, "Durga", 7123);//
		Person p81 = new Person(81, "Haritha", 8123);//
		Person p91 = new Person(91, "Bavya", 9123);//

		// Adding individual objects
		persons.add(p11);
		persons.add(p21);
		persons.add(p31);
		persons.add(p41);
		persons.add(p51);
		girls.add(p51);
		persons.add(p61);
		girls.add(p61);
		persons.add(p71);
		girls.add(p71);
		persons.add(p81);
		girls.add(p81);
		persons.add(p91);
		girls.add(p91);

		System.out.println("-------Object Iterator ----");
		Iterator<Person> objIterator = persons.iterator();
		while (objIterator.hasNext()) {
			Person p = (Person) objIterator.next();
			System.out.println(p.getName());
		}

		System.out.println("------- Object forEach ----");
		for (Person p : persons) {
			System.out.println(p.getName());
		}

		// Remove All girls

		System.out.println("------- Remove all girls Iterator ----");

		persons.removeAll(girls);

		Iterator<Person> boys = persons.iterator();
		while (boys.hasNext()) {
			Person p = (Person) boys.next();
			System.out.println(p.getName());
		}

		// Add All girls

		System.out.println("------- Adding back all girls Iterator ----");

		persons.addAll(girls);

		Iterator<Person> yo = persons.iterator();
		while (yo.hasNext()) {
			Person p = (Person) yo.next();
			System.out.println(p.getName());
		}

		// Retain All girls

		System.out.println("------- Retain all girls Iterator ----");

		persons.retainAll(girls);

		Iterator<Person> girl = persons.iterator();
		while (girl.hasNext()) {
			Person p = (Person) girl.next();
			System.out.println(p.getName());
		}

		// Make copy of Girls Array List
		ArrayList<Person> women = new ArrayList<>(girls);
		System.out.println("-------Copied  Object forEach ----");
		for (Person p : women) {
			System.out.println(p.getName());
		}

		// Check whether Janani is girl :-)
		// contains() method in LIST interfacewill use Equals method, so if both
		// objects
		// have same reference variable then contains() will evaluates to TRUE
		// Even if object has same value but different reference it will
		// evaluates to FALSE

		Person p151 = new Person(31, "Gopal", 3123); // same object different
														// reference

		// case:1
		women.add(p151);
		// case: 2
		// p151=p51;
		// women.add(p151);

		System.out.println("Is Gopal in the girls list ?? "
				+ arrayList.contains("Gopal"));

		System.out.println("Is Gopal in the girls list ?? "
				+ persons.contains(women.get(women.size() - 1)));

		// Remove all elements from the list
		women.clear();
		System.out.println("-------Copied Object forEach after clearing----");
		for (Person p : women) {
			System.out.println(p.getName());
		}

		/*
		 * Additional Info indexOf(Object o) Returns the index of the first
		 * occurrence of the specified element in this list, or -1 if this list
		 * does not contain the element.
		 */

		// Syncronization of list: Only one thread can access @ a time

		Collections.synchronizedList(persons);

		// Is null allowed in Arraylist ?? check out

		persons.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);

		System.out.println("-------NUll insertion @ primitive level----");
		for (String p : arrayList) {
			System.out.println(p);
		}

		System.out.println("-------NUll insertion @ OBJECT level----");
		for (Person p : persons) {
			System.out.println(p.getName());
		}

	}
}
