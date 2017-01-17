package com.vinodh.javaBasicsFromOracle;

import java.util.Arrays;

public class arrayUtilClass {

	public static void main(String[] args) { 
		int[] copyFrom = {122,12,3,412,53,6,7,8,9};
		int[] copyTo = new int[5];
		System.arraycopy(copyFrom, 0, copyTo, 0, 5);
		System.out.println("copy from Range by creating destination array");
		
		for (int i = 0; i < copyTo.length; i++) {
			System.out.println(copyTo[i]);
		}
		
		System.out.println("copy from Range using arrays");
		// java.util.Arrays
		int[] copyToArrays = Arrays.copyOfRange(copyFrom, 0, 5);
		for (int i = 0; i < copyToArrays.length; i++) {
			System.out.println(copyToArrays[i]);
		}
		System.out.println("After sorting");
			
		Arrays.parallelSort(copyToArrays);
		for (int i = 0; i < copyToArrays.length; i++) {
			System.out.println(copyToArrays[i]);
		}
		

		System.out.println("Binary Search--> return index ");
		
		System.out.println(Arrays.binarySearch(copyFrom, 53));
	

		System.out.println("comparing two arrays for equality--> return Boolean [same number of elements, same order == true]");
		
		System.out.println(Arrays.equals(copyTo, copyToArrays));
		
		System.out.println("filling an array to place specific value at each index");
		
		Arrays.fill(copyToArrays, 0, 5, 143);
		
		 	
		for (int i = 0; i < copyToArrays.length; i++) {
		 	
			System.out.println(copyToArrays[i]);
		}
	}

}
