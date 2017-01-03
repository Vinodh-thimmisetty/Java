package com.vinodh.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * Data Structure : LinkedList --> Doubly Linked List implemention
 * Insertion Order : Preserved
 * Duplicates : Allowed
 * Allows any type of objects [Homogenous or Heterogenous]
 * NULL insertions : Yeah !!
 * Synchoronized : NO !!
 * Support Generics
 * Support Iterators & forEach & Streams(java 8) 
 * 		[[ elements in the list can be added/removed with help of Iterators but not with forEach ]] 	
 * Can be used to implement  STACK && QUEUE Linear data structures
 * Algorithm Features:
 *  Searching: Random access is not possible, have to traverse each and every element in the list
 *  Deletion : Easy
 *  Insertion : Easy
 *  Sorting : Can be sort with help of Collections utility class
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class LinkedListOverview {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 LinkedList<String> linkedList = new LinkedList<>();
	 
	
	 linkedList.add("Vinodh"); // Appends @ end of the List
	 linkedList.add(0, "Kranthi"); // Inserts @ specified Index in the List
	 linkedList.addFirst("Gopal"); // Inserts @ start of list
	 linkedList.addLast("Pavan");	 // Insert @ End of List 
	 
	 
	 linkedList.offer("Bavya"); // Insert @ End of List 
	 linkedList.offerFirst("Janani"); // Insert @ Start of List 
	 linkedList.offerLast("durga"); // Insert @ End of List
	
	  
	 Iterator<String> ll  = linkedList.iterator();
	 while (ll.hasNext()) {
		String string = (String) ll.next();
		System.out.println("initial inserts --->"+string);
	}
	 	
	 System.out.println("index 1 -->"+linkedList.get(1) ); // Retrieve specified index in the List
	 System.out.println("First -->"+linkedList.getFirst() ); // Retrieve First element in the List
	 System.out.println("Last -->"+linkedList.getLast());// Retrieve Last element in the List

	 linkedList.remove() ;//Retrieves and removes the head (first element) of this list.
	 linkedList.removeFirst();
	 linkedList.removeLast();
	 
	 	
	  ll  = linkedList.iterator();
	 while (ll.hasNext()) {
		String string = (String) ll.next();
		System.out.println("AFTER dELETES --->"+string);
	}
	 
	 System.out.println("Head Element is --->"+linkedList.peek()); //	 Retrieves, but does not remove, the head (first element) of this list.
	 System.out.println("First element in the list is --->"+linkedList.peekFirst()); //	 Retrieves, but does not remove, the FIRST element of this list, or returns null if this list is empty.
	 System.out.println("First element in the list is --->"+linkedList.peekLast()); //	Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
	 
	 linkedList.poll();// Retrieves and removes the head (first element) of this list.
	 linkedList.pollFirst();// Retrieves and removes the first element of this list, or returns null if this list is empty.
	 linkedList.pollLast();// Retrieves and removes the LAST element of this list, or returns null if this list is empty.
	 
	 linkedList.push("Jaffas"); // Pushes an element onto the stack represented by this list.
	 linkedList.pop(); //Pops an element from the stack represented by this list.
	 
	 	
	  ll  = linkedList.iterator();
	 while (ll.hasNext()) {
		String string = (String) ll.next();
		System.out.println("Before  removing all --->"+string);
	}
	 
	 linkedList.removeAll(linkedList); //Retrieves all elements in the list.
		
	 
	
	}

}
