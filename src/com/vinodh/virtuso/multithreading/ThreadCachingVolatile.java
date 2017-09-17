package com.vinodh.virtuso.multithreading;

import java.util.Scanner;

/**
 * 
 * Thread which is in sleep mode can only be returned using interruption signals
 * Else, interrupted exception will be thrown.
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */

public class ThreadCachingVolatile {

	/**
	 * Make Sure the Thread not to Cache instance variables. This has to available
	 * for all Running Threads including the MAIN thread.
	 * 
	 * To avoid this(Prevent Threads from CACHING), volatile keyword is used
	 */
	private static volatile boolean isRunning = true;

	public static void shutdonw() {
		isRunning = false;
	}

	public static void main(String[] args) {
		new Thread(() -> {
			while (isRunning) {
				System.out.println("Hello >> " + Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		// Stop the Thread if ENTER is pressed in CONSOLE
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextLine(); // Press ENTER
			shutdonw();

		} finally {
			// Automatic closure of Scanner will happen
		}
	}
}
