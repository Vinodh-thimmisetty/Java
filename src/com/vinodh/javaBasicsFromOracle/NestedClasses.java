package com.vinodh.javaBasicsFromOracle;

public class NestedClasses {
	private int a=10;
	 static class staticInnerClass{
		private int a= 20;

		public void innerMethod(int a){
			System.out.println("inner method paramter=="+a);
			System.out.println("inner class variable =="+this.a);
			//System.out.println("outer class variable =="+OuterClasses.this.a); // compile error 
		 	
		}
	}
	class insideClass{
		private int a=30;
		
		public void innerMethod(int a){
			System.out.println("inner method paramter=="+a);
			System.out.println("inner class variable =="+this.a);
			System.out.println("outer class variable =="+NestedClasses.this.a);
		}
	}

	public static void main(String[] args) { 
// normal outer class
		NestedClasses outerClasses = new NestedClasses();
		// static inner Class
		NestedClasses.staticInnerClass innerClassStatic = new NestedClasses.staticInnerClass();
		     // normal inner Class
		NestedClasses.insideClass inClass = outerClasses.new insideClass();
		
		         // static method
		        innerClassStatic.innerMethod(143);
		        
		        // normal method
		        inClass.innerMethod(789);
		        
		        // access top level instance variable from static inner class
		         // Need to find out the way
	}

}
