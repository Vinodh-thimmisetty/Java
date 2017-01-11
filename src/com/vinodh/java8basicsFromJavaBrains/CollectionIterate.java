package com.vinodh.java8basicsFromJavaBrains;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionIterate {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 52),
				new Person("Thomas", "Carlyle", 43), new Person("Charlotte", "Bronie", 45),
				new Person("Vinodh", "kumar", 24));

		// for loop
		System.out.println("for loop ----External ");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}

		// Iterator
		System.out.println("Iterator-------");
		Iterator<Person> iterator = people.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// List Iterator
		System.out.println("List Iterator-------");
		ListIterator<Person> lit = people.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}

		// for each
		System.out.println("for -each------- External ");
		for (Person person : people) {
			System.out.println(person);
		}

		// java -8 runtime
		// for each
		System.out.println("for -each------- internal--lambda ");
		people.forEach(p -> System.out.println(p));
		System.out.println("for -each------- internal--Method Reference ");
		people.forEach(System.out::println);

		// java -8 streams
		System.out.println("streams----");
		people.stream().forEach(System.out::println);

	}

}
