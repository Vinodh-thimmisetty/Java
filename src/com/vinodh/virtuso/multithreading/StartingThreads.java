package com.vinodh.virtuso.multithreading;

/**
 * Different Ways of starting the Thread
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class StartingThreads {

	/*
	 * Extending the Thread
	 * 
	 */
	class ClassExtendsThread extends Thread {

		@Override
		public void run() {
			System.out.println("I am extended class >>>" + Thread.currentThread().getName());
		}
	}

	/**
	 * Implementing the Runnable
	 * 
	 */
	class ClassImplementsRunnable implements Runnable {

		@Override
		public void run() {

			System.out.println("I am implemented class >>>" + Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		StartingThreads s = new StartingThreads();
		// Start thread using Extended class
		new Thread(s.new ClassExtendsThread()).start();
		Thread.sleep(100);
		// Start thread using Runnable Implementation
		new Thread(s.new ClassImplementsRunnable()).start();
		Thread.sleep(100);
		// start thread
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am implementing anonymously >>>" + Thread.currentThread().getName());
			}
		}).start();
		Thread.sleep(100);
		// Start Thread Java-8 way with Lambdas
		new Thread(() -> System.out.println("Lambda way of Running thread >>>" + Thread.currentThread().getName()))
				.start();
		Thread.sleep(100);

	}

}
