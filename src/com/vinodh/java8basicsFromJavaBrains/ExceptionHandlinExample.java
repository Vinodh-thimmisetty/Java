package com.vinodh.java8basicsFromJavaBrains;

import java.util.function.BiConsumer;

public class ExceptionHandlinExample {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5 };
		int key = 0;

		// Exception Handling Traditional
		process(num, key, (v, k) ->{
			
			try{
				System.out.println(v / k);
			}catch (Exception e) {
				System.out.println("arith exce");
			}
	
		});
		// Exception Handling Lamdba approach
		lambdaProcess(num,key,wrapperLambda((v,k)->System.out.println(v / k)));
	}

	public static void process(int[] is, int k, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : is) {
			biConsumer.accept(i, k);
		}

	}
	
	public static void  lambdaProcess(int[] is ,int k,BiConsumer<Integer, Integer> biConsumer){
		for (int i : is) {
			biConsumer.accept(i, k);
		}
	}
	
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer){
		return (v,k) ->{
			try{
				biConsumer.accept(v, k);//(v,k)->System.out.println(v / k)
			}catch (Exception e) {
				 System.out.println("lamda way ---");
			}
		};
	}

}
