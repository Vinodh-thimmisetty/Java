package com.vinodh.virtuso.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * There will be only ONE lock per object. So, No TWO threads can run same logic
 * at one time.
 * 
 * Lock will be given to OBJECT but not THREAD.
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class ThreadMultiLockSyncronization {

	private static Random random = new Random();

	// Locked Objects
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static List<Integer> list1 = new ArrayList<>();
	private static List<Integer> list2 = new ArrayList<>();

	public static void stage1() {
		System.out.println(Thread.currentThread().getName() + " is trying to access stage1");
		synchronized (lock1) {
			System.out.println("stage1 is locked by >> " + Thread.currentThread().getName());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));

		}
	}

	public static void stage2() {
		System.out.println(Thread.currentThread().getName() + " is trying to access stage 2");

		synchronized (lock2) {
			System.out.println("stage2 is locked by >> " + Thread.currentThread().getName());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));

		}
	}

	public static void procesStages() {
		for (int i = 0; i < 10; i++) {
			stage1();
			stage2();
		}
	}

	public static void main(String[] args) {
		System.out.println("Thread starts......");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				procesStages();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				procesStages();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println(end - start);
		System.out.println("List1 size >>" + list1.size());
		System.out.println("List2 size >>" + list2.size());

		System.out.println("Thread Ends....");
	}
}
