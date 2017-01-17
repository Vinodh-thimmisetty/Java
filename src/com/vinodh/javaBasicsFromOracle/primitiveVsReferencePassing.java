package com.vinodh.javaBasicsFromOracle;
/***
 * 
 * Method pass by value vs pass by reference
 * 
 * 
 * @author Vinodh
 *
 */
public class primitiveVsReferencePassing {

	public static void main(String[] args) { 
		int x=3;
	    
        // invoke passMethod() with 
        // x as argument
        passMethod(x);
           
        // pass by value
        System.out.println("After invoking passMethod, x = " + x);
           
        
        Dog dog = new Dog();
        dog.setName("Pinky");
        System.out.println("before passing dog as reference -->"+dog);
    	
        dogName(dog);
        System.out.println("after passing dog as reference -->"+dog);
    	
	}
	  // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }
    public static void dogName(Dog d){
    	System.out.println("inside method, before changing the method reference -->"+d);
    	
    	d = new Dog();
    	d.setName("Jaffa");
    	
    	System.out.println("inside method, After changing the method reference -->"+d);
    	
    }

}
