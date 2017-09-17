package com.vinodh.virtuso.multithreading;

/**
 * 
 * Multiple Threads accessing/performing operation on the Same/Shared Variable
 * then always there is mismatch of mapping correct current value to Thead.
 * 
 * 
 * CACHING + SYNCronization(Intrinsic LOCK which can be acquired by ONE thread
 * at any point of time) is required
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class ThreadSynchronizeKeyword {
	private int count = 0;

	public synchronized void increment() {
		// Current State of variable will be available
		count++;
	}

	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count is >>" + count + "   >> " + Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		try {
			new ThreadSynchronizeKeyword().doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
