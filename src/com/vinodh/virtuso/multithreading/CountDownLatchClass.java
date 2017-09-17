package com.vinodh.virtuso.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processer implements Runnable {

	private CountDownLatch countDownLatch;

	public Processer(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {

		System.out.println("started....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}

}

public class CountDownLatchClass {

	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			executorService.submit(new Processer(countDownLatch));
		}

		System.out.println("Completed.......");
		
		try {
			countDownLatch.await(1, TimeUnit.DAYS);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
	}
}
