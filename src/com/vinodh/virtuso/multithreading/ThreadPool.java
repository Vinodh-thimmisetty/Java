package com.vinodh.virtuso.multithreading;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {
	private int id;

	public ThreadPool(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("starting.." + id);

		try {
			Thread.sleep(5000);
			System.out.println("Current thread is .." + Thread.currentThread().getName());

		} catch (InterruptedException e) {
		}
		System.out.println("completed.." + id);
	}

	public static void main(String[] args) {
		System.out.println("Current thread is .." + Thread.currentThread().getName());
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executorService.submit(new ThreadPool(i));
			System.out.println("Current thread is .." + Thread.currentThread().getName());

		}
		executorService.shutdown();
		System.out.println("Current thread is .." + Thread.currentThread().getName());

	}
}
