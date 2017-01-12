package com.vinodh.java8basicsFromJavaBrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
// FUNCTIONAL Interface methods in JAVA.UTIL.FUNCTIONS will take priority to normal function interfaces , during method Overloading 
public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 52),
				new Person("Thomas", "Carlyle", 43), new Person("Charlotte", "Bronie", 45),
				new Person("Vinodh", "kumar", 24));

		// Sort list by last name

		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});

		// using Lambdas
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// method which will print all elements in the list
		System.out.println("\nmethod which will print all elements in the list");
		printElements(people);

		// method which will print all lastname having C
		System.out.println("\nmethod which will print all lastname having C");
		printLastNames(people);

		// Java-7 with Inner class
		System.out.println("\nJava-7 with Inner class -- lastname having C");

		printConditionally(people, new Conditions() {

			@Override
			public boolean test(Person person) {

				return person.getLastName().startsWith("C");
			}

		});

		// Java -8 with Lambdas
		System.out.println("\nJava-8 labmdas -- lastname having C");

		printConditionally(people, (p) -> p.getLastName().startsWith("C"));

		System.out.println("\nJava-8 labmdas conditon always true----");

		printConditionally(people, p -> true);
		System.out.println("\nJava-8 labmdas generic conditon functions from java.util.functions");
		printUtilConditionFunnction(people, p -> p.getLastName().startsWith("C"));

		System.out.println("\nJava-8 labmdas generic conditon + behaviour functions from java.util.functions");
		printUtilConditionFunnctionBehaviour(people, p -> p.getLastName().startsWith("C"),
				p -> System.out.println(p));


		System.out.println("\nJava-8 labmdas generic conditon + behaviour functions as Method References");
		printUtilConditionFunnctionBehaviour(people, p -> p.getLastName().startsWith("C"),
				System.out::println);

		
	}

	public static void printElements(List<Person> y) {
		for (Person person : y) {
			System.out.println(person);
		}

	}

	public static void printConditionally(List<Person> p, Conditions conditions) {
		for (Person person : p) {
			if (conditions.test(person)) {
				System.out.println(person);
			}
		}
	}

	public static void printUtilConditionFunnction(List<Person> p, Predicate<Person> conditions) {
		for (Person person : p) {
			if (conditions.test(person)) {
				System.out.println(person);
			}
		}
	}

	public static void printUtilConditionFunnctionBehaviour(List<Person> p, Predicate<Person> conditions,
			Consumer<Person> consumer) {
		for (Person person : p) {
			if (conditions.test(person)) {
				consumer.accept(person);
			}
		}
	}

	public static void printLastNames(List<Person> u) {
		for (Person person : u) {
			if (person.getLastName().startsWith("C")) {
				System.out.println(person);
			}
		}
	}

	interface Conditions {
		boolean test(Person person);
	}
}
