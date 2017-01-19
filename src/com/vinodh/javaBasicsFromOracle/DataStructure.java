package com.vinodh.javaBasicsFromOracle;

import java.util.Iterator;

/**
 * inner Class Example
 * you create an array, fill it with integer values, and then output only values of even indices of the array in ascending order.
 * inner class will access outer class instance variables
 * @author Pavan
 *
 */
public class DataStructure {

	private int[] arr = new int[10];
	public DataStructure(){
		for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.println("i value==="+i);
        }
	}
	
	public void printEven(){
		EvenIterator evenIterator = this.new EvenIterator();
		while(evenIterator.hasNext()){
			System.out.println("===even values==="+evenIterator.next());
		}
	}
	
	private class EvenIterator implements Iterator<Integer>{

		private int nextIndex=0;
		
		 public boolean hasNext() { 
			return nextIndex<arr.length-1;
		}

		 public Integer next() { 
			Integer integer = Integer.valueOf(arr[nextIndex]);
			nextIndex +=2;
			return integer;
		}
		
	}
	public static void main(String[] args) { 
		DataStructure dataStructure = new DataStructure();
		 dataStructure.printEven();

	}

}
