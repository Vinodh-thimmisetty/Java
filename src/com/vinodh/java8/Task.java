package com.vinodh.java8;

import java.time.LocalDate;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
	private final String id;
	private final String title;
	private final TaskType type;
	private final LocalDate createdOn;
	private boolean done;
	private Set<String> tags;
	private LocalDate dueOn;

	public enum TaskType {
		READING, WRITING, CODING, SLEPPING
	}

}
