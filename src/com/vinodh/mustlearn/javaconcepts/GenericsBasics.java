package com.vinodh.mustlearn.javaconcepts;

import java.util.Collection;
import java.util.List;

/**
 *  Used to handle most of the errors @ Compile Time && enable TYPES(Classes/Interfaces or any object) checking
 *  Reuse the same code with different inputs i.e., Declare the type of Object so that we can pass any subclass to fit  the type
 *  E.g:  List<String> list ; ==> COmpiler e]will make sure all the elements passes to the list or String 
 *  Generic Type --> classes
 *  Generic Methods --> Methods (scope is limited to method)
 *  The most commonly used type parameter names are:
 	E - Element (used extensively by the Java Collections Framework)
	K - Key
	N - Number
	T - Type
	V - Value
	S,U,V etc. - 2nd, 3rd, 4th types
	
	
	To use Java generics effectively, you must consider the following restrictions:

	Cannot Instantiate Generic Types with Primitive Types
	Cannot Create Instances of Type Parameters
	Cannot Declare Static Fields Whose Types are Type Parameters
	Cannot Use Casts or instanceof With Parameterized Types
	Cannot Create Arrays of Parameterized Types
	Cannot Create, Catch, or Throw Objects of Parameterized Types
	Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type

 * @author Vinodh Kumar Thimmisetty
 * @param <T> the type of the value
 */
public class GenericsBasics<T> {
	private T t;
	private String jaffa;

	public GenericsBasics() {

	}

	public GenericsBasics(T t,String jaffa) {
		this.t = t;
		this.jaffa =jaffa;
	}
	  
	public T getT(){
		return this.t; 
	}
	
	// Generic Method
	public static <K,V> boolean testGenericMethod(Pair<K,V> p1, Pair<K,V> p2){
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
	
	//Bound Type Parameters :: Restricting the TYPE to certian instances
	public <U extends Number> void testBoundType(U u){
		System.out.println("I will allow only Number and its subclasses :-O");
		// I will acccept methods of NUMBER too :-)
		u.toString();
	}
	// Multiple Bounds
	public <U extends Number & AutoCloseable & Collection> void testMultipleBounds(U u){
		System.out.println("I will allow Number, Autocloasable ,collections and its methods &&& ORDER iof extends is important");
		
	}
	
	// Wild Cards (?) 
	// Upper bound List<? extends ######>
	public static  List<? extends Number> testWildCards(List<? extends Number> list){
		for (Number e : list) {
			System.out.println(e);
		}
		return null;
	}
	// Unbound wild cards List<?>
	// Useful test scenario
	public static void testUnbound(List<Object> l){
		for (Object object : l) {
			System.out.println(" List<object> and its subclasses ==="+object);
		}
		
		// if i pass List<Integer> ==> it wont compile because Integer is a sub class of Object but not List<Integer> is sub type of List<Object>
		
	}
	
	// ubound example
   public static void testUnboundExample(List<?> list){
	   for (Object object : list) {
		System.out.println("Any type which is sub type");
	}
   }
	// Lower bound : List<? super ####> , all of its super types
   public static void testLowerBound(List<? super Integer> list){
	   for (Object object : list) {
		System.out.println("all integers + its super types");
	}
   }
	public static void main(String[] args) {
		// To reference the generic class, perform a generic type invocation,
		// which replaces T with some concrete value, such as Integer:

		GenericsBasics<Integer> basics = new GenericsBasics<>();
		//Raw Type of Generic class
		 GenericsBasics basics2 = new GenericsBasics();
		 
		 // Backward compatibility i.e., old code will still support new Generics
		 GenericsBasics valid = basics;
		 
		 // Calling constructor with generics + noraml variable
		 GenericsBasics<Integer> genericsBasics = new GenericsBasics<Integer>(2, "pavan");
		 System.out.println("value --->"+genericsBasics.getT());
		 
		 // Checking Generic Methods::
		 GenericsBasics<Integer> yoo = new GenericsBasics<Integer>(143, "samantha");
		 Boolean isSame =yoo.<Integer,Integer>testGenericMethod(new Pair<Integer,Integer>(1, 2), new Pair<Integer,Integer>(1, 2));
		 // TYPE INFERENCE >> Automatic Return type detection :-)
		 Boolean isSame2 =yoo.testGenericMethod(new Pair(1, 2), new Pair(1, 2));

		System.out.println("is same---" + isSame);
		System.out.println("is same2---" + isSame2);

	//	yoo.testBoundType("Vinodh"); // Compile Error
		yoo.testBoundType(789); 
		
		
		// V.V.IMP :: For Number Generic TYPE , we can pass Integer,Double or any sub types which are compatible with NUMBER
		// but Class<Number> generic type, we cannot pass Class<Number> because, they are not in Inheritance hierarchy

		
		
	}
	

}

class Pair<K, V> {
	private K kValue;
	private V vValue;

	public Pair(K k, V v) {
		this.kValue = k;
		this.vValue = v;
	}

	public K getKey() {
		return kValue;
	}

	public V getValue() {
		return vValue;
	}
}
