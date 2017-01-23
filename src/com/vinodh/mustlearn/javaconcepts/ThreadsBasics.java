package com.vinodh.mustlearn.javaconcepts;

/**
 *  Concurrency :: Multiple tasks happening @ same time i.e, working on multiple Processes(Programs) which has its own threads running inside it.
 *  So basically, threads are the internal workers of any program which can talk each other unlike process and share the resource if required
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class ThreadsBasics {

	/***
	 * 
	 * Each Thread is associated to an instance of Thread class which has run(),start(), wait(),notify(),destroy() etc .methods
	 * An application that creates an instance of Thread must provide the code that will run in that thread.  
	 * 
	 */
	class TestThreadRunnable implements Runnable{

		@Override
		public void run() {
			 System.out.println("Runnable instance of Thread--> you can place the code here, I will run in this thread & you can pass instance of me to your thread construcor");
		}
		
	}
	
	/**
	 * Thread implements Runnable and implements RUN() method, so we can create new threads by extending THREAD
	 * 
	 * 
	 */
	class TestThread extends Thread{

		@Override
		public void run() {
			 System.out.println("Thread instance run method, it will override super class thread method");
		}
	}
	 
	public static void main(String[] args) throws InterruptedException {
	 ThreadsBasics basics = new ThreadsBasics();
	 // Runnable instance
	 new Thread(basics.new TestThreadRunnable()).start();
	 // Thread Instance
	 new Thread(basics.new TestThread()).start();
	// Sleep :: stop the execution and wait for some time. While i am sleeping if some other thread tries to access me, i will throw interrupted exception
 	 // Interrupt :: It is an indication to a thread that it should stop what it is doing and do something else
	 //Many methods that throw InterruptedException, such as sleep, are designed to cancel their current operation and return immediately when an interrupt is received.
	 
	 String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
	 
	 System.out.println("time-before for loop----->"+new java.util.Date()+ Thread.currentThread().getName());

	 	
	 for (int i = 0; i < importantInfo.length; i++) {
		Thread.sleep(4000); // milliseconds
		System.out.println("time--->"+new java.util.Date()+"----->"+importantInfo[i]+Thread.currentThread().getName());
	if(Thread.interrupted()){
		System.out.println("some one interrupted me, and i am clearing my interrupted status");
	}
	 }

	 //Join :: The join method allows one thread to wait for the completion of another.
 	 new Thread(basics.new TestThread()).join(); //causes the current thread to pause execution until this thread terminates [[ can specify millis + nanos timing like sleep]]
	 
	 
	 for (int i = 0; i < importantInfo.length; i++) {
		Thread.sleep(4000, 10000);// millis + Nano seconds
		System.out.println("time--->"+new java.util.Date()+"----->"+importantInfo[i]+Thread.currentThread().getName());
		if(new Thread().isInterrupted()){
			System.out.println(" i am thread specific (non-static) && some one interrupted me, and i won't clear my interrupted status");
		}
		
	 }
	 

	 
	}

}
