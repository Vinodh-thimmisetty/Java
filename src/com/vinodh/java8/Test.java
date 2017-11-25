package com.vinodh.java8;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vinodh.java8.Task.TaskType;

public class Test {

	/**
	 * IllegalStateException(stream has already been operated upon or closed) will be
	 * thrown if stream is used after termination opertions
	 * 
	 * @param args
	 */ 	
	public static void main(String[] args) {
		// Prepare the Functional interface behavior
		
		// Predicate :: Accept any input type and return Boolean value
		Predicate<Task> readingTask = task -> TaskType.READING.equals(task.getType());
		
		// Consumer :: Accept any input type and return NOTHING
		Consumer<String> printTasks  = task -> System.out.println(task);
		
		// BiConsumer :: Accept any TWO input type and return NOTHING
		BiConsumer<? extends Object, ? extends Object> loopMap =  (key,value)->System.out.println(key+":"+value);
		
		// Supplier:: Accept NOTHING but returns any type
		Supplier<Double> piValue = () -> Math.PI;
		
		// Function:: Accept ONE argument of any input type and return only ONE output type
		Function<Task, String> title = task->task.getTitle();
		
		// BiFunction:: Accept TWO arguments of any input type and return any ONE Output type
		BiFunction<String, String, String> appendStrings = (x,y) -> "X is:: "+x+" and y is:: "+y;
	 
		
		// Filter all tasks which are of Tasktype Reading
		Stream<Task> filteredTasks = tasks().stream()
											.filter(readingTask);

		// print filtered tasks
		// filteredTasks.forEach(System.out::println);

		// Sort the filtered tasks based on created date
		Stream<Task> sortedTasks = filteredTasks
												.sorted((x, y) -> x.getCreatedOn().compareTo(y.getCreatedOn()));
		
		//Stream<Task> sortBasedOnTitle = filteredTasks.sorted(Comparator.comparing(Task::getTitle));
		
		//Stream<Task> reverseSortTitles = filteredTasks.sorted(Comparator.comparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());

		// print sorted tasks
		// sortedTasks.forEach(System.out::println);

		// Get the Title from above Filtered and Sorted Tasks
		List<String> taskTitlesList = sortedTasks
												.map(title)
												.collect(Collectors.toList());
		// print Titles
		// taskTitlesList.forEach(printTasks);
		
		 List<Task> tasks = tasks();
		//tasks.stream().collect(Collectors.groupingBy(Task::getType)).forEach((BiConsumer<? super TaskType, ? super List<Task>>) loopMap);
		//tasks.stream().collect(Collectors.groupingBy(Task::getTags,Collectors.mapping(Task::getTags, Collectors.toList()))).forEach((BiConsumer<? super Set<String>, ? super List<Set<String>>>) loopMap);
		 
		 tasks.stream().collect(Collectors.partitioningBy(tt->tt.getCreatedOn().isAfter(LocalDate.now()))).forEach((x,task)->System.out.println(task));

	}

	//@formatter:off
	public static List<Task> tasks(){
		return Stream.of(Task.builder()
							 .id("1")
							 .title("Reading Git")
							 .type(TaskType.READING)
							 .createdOn(LocalDate.of(2017, Month.NOVEMBER, 25))
							 .tags(Stream.of("git","version control","eclipse").collect(Collectors.toSet()))
							 .done(false)
							 .dueOn(LocalDate.of(2018, Month.DECEMBER, 12))
							 .build(),
						Task.builder()
							 .id("2")
							 .title("Reading Java")
							 .type(TaskType.READING)
							 .createdOn(LocalDate.of(2016, Month.NOVEMBER, 25))
							 .tags(Stream.of("eclipse","java","programming").collect(Collectors.toSet()))
							 .done(true)
							 .dueOn(LocalDate.of(2017, Month.JULY, 12))
							 .build(),
					   Task.builder()
							 .id("3")
							 .title("Coding the Application")
							 .type(TaskType.CODING)
							 .createdOn(LocalDate.of(2017, Month.JUNE, 25))
							 .tags(Stream.of("coding","programming","java","eclipse").collect(Collectors.toSet()))
							 .done(false)
							 .dueOn(LocalDate.of(2020, Month.DECEMBER, 12))
							 .build(),
						Task.builder()
							 .id("4")
							 .title("Writing the Blog")
							 .type(TaskType.WRITING)
							 .createdOn(LocalDate.of(2014, Month.FEBRUARY, 25))
							 .tags(Stream.of("blog","writing","money").collect(Collectors.toSet()))
							 .done(false)
							 .dueOn(LocalDate.of(2019, Month.JULY, 12))
							 .build(),
					   Task.builder()
							 .id("5")
							 .title("Sleeping peacfully")
							 .type(TaskType.SLEPPING)
							 .createdOn(LocalDate.of(1993, Month.FEBRUARY, 25))
							 .tags(Stream.of("one","two","three").collect(Collectors.toSet()))
							 .done(false)
							 .dueOn(LocalDate.of(2093, Month.JULY, 12))
							 .build(),
					  Task.builder()
							 .id("6")
							 .title("Reading Spring")
							 .type(TaskType.READING)
							 .createdOn(LocalDate.of(2014, Month.NOVEMBER, 25))
							 .tags(Stream.of("java","mvc","eclipse","spring").collect(Collectors.toSet()))
							 .done(false)
							 .dueOn(LocalDate.of(2020, Month.DECEMBER, 12))
							 .build()).collect(Collectors.toList());
	}
	//@formatter:on
}
