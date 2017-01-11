package com.vinodh.java8basicsFromJavaBrains;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 52),
				new Person("Thomas", "Carlyle", 43), new Person("Charlotte", "Bronie", 45),
				new Person("Vinodh", "kumar", 24));

		// result sub list of matching conditions
		people
			.stream()
				.filter(p -> p.getFirstName().startsWith("C"))
				.filter(p -> p.getAge() > 30) 
					.forEach(System.out::println);
		
		System.out.println("count-->"+people.parallelStream().filter(p->p.getAge()<50).count());

	}

}
