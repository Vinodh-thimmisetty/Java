package com.vinodh.java8basicsFromJavaBrains;

public class Greeter {
	
	public void greet(){
		System.out.println("Hello World !");
	}
	
	// Passing behaviour
	public void greet(Greeting greeting){
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter g = new Greeter();
		g.greet();
		
		// Concrete implementations
		HelloWorldGreeting h = new HelloWorldGreeting();
		g.greet(h);
		
		//Anonymous inner classes
				Greeting gg = new Greeting() {
					
					@Override
					public void perform() {
						System.out.println("hello inner class world !!!");
					}
				};
				
				g.greet(gg);
	
		// Lambda Expressions 
		 
		Greeting myLamdaFunction = ()->System.out.println("Hello World Lamdas !!!");
	 	g.greet(myLamdaFunction);
	 	
	 	// Type inference in Lambdas
	 	g.greet(()->System.out.println("Hello World inline Lamda expression !!!"));
	
	 
	
	}
	
	interface MyLamda {
		void foo();
	}

}
