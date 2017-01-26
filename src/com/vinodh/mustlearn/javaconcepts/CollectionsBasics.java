package com.vinodh.mustlearn.javaconcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *Core Collection(Collection<--(Set<--Sortedset),List,Queue,Deque)  &&& Map<--SortedMap, all INTERFACES are GENERIC ==> Reduce Errors @ Runtime
 * :: Duplicates :: Insertion Order :: Sorted ==> Basic Criteria for differentiating the Collections Framework
 * 
 *  SET ==> No Duplicates && Sortedset ==> Natural Sort Order
 *  List ==> Ordered(Insertion order) or Sequence + Can have Duplicates
 *  MAP ==> (KEY,VALUE) pairs + No Duplicate Keys && SortedMap ==> Natural Sort Order of Keys
 *  Queue ==>  Hold Multiple elements prior processing FIFO/LIFO && Deque ==> two way accessing either from HEAD/TAIL OF Queue	
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class CollectionsBasics {

	public static void main(String[] args) {
		/****
		 * 
		 * Collection Interface ::: Top Level of Collections Framework ==> NO Direct Implementation, but has methods which can be used for concrete class
		 * 
		 */
		Collection<Integer> collection = null;
		collection = new ArrayList<>();
		//collection = new HashSet<>();
		//collection = new PriorityQueue<>();
	  //collection = new HashMap(); // Compile Error as MAP is not s sub interface/class of collection hierarchy
		
		
		// Traversing a collection ==> ## 3 types of Cursors
		// Aggregate
		collection.stream().filter(p->p.intValue() >0).forEach(System.out::println);
		collection.stream().map(Object::toString).collect(Collectors.summarizingInt(p->p.toString().length()));
		// Foreach
		for (Integer integer : collection) {
			integer.intValue();
		}
		//Iterators ==> use this when collection needs to modify while fetching one-by-one
		Iterator<Integer> iterator =collection.iterator();
		while(iterator.hasNext()){
			iterator.next();
			iterator.remove();
			iterator.forEachRemaining(p->p.parseInt("vinodh"));
			iterator.notifyAll();
		}
		ArrayList<Integer> lsti = (ArrayList<Integer>)collection;
		ListIterator<Integer> listIterator = lsti.listIterator();
		while(listIterator.hasNext() && listIterator.hasPrevious()){
			listIterator.next();
			listIterator.previous();
			listIterator.remove();
			listIterator.forEachRemaining(System.out::println);
		}
		
		/****
		 * SET Interface(<--HashSet(Hashtable, no guarantee of insertion order),LinkedHashSet(Hashset ++ Linkedlist which supports insertion Order),TreeSet(Red-Black Trees, Sort based on values ASC))
		 *  :: ==> Inherited Methods from Collection ++ Duplicate element restriction methods
		 *  
		 */
		
		// Remove Duplicates From Collection of elements 
		Integer[] testWithDuplicates ={1,2,3,5,6,2,4,8,9,1,2,5,6,77,80,3,3,32,2,5,6};
		Collection<Integer> integers = Arrays.asList(testWithDuplicates);
		for (Integer integer : integers) {
			System.out.println("->"+integer);
		}
		System.out.println("---- JAVA 7 way--------");
		Collection<?> collect = new HashSet<>(integers);
		collect.stream().forEach(System.out::println);
		System.out.println("-----JAVA 8 way-------");
		integers.stream().collect(Collectors.toSet()).forEach(System.out::println); 
		System.out.println("-----JAVA 8 way convert to TreeSET (Ascending Order of elements)-------");
		integers.stream().collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
		System.out.println("-----JAVA 8 way convert to LinkedHashset (Insertion Order of elements)-------");
		integers.parallelStream().collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
		System.out.println("-----JAVA 8 way Tree set with DESC order-------");
		integers.parallelStream().collect(Collectors.toCollection(TreeSet::new)).descendingIterator().forEachRemaining(System.out::println);;

		System.out.println("--------------");
		/****
		 * LIST Interface
		 *  :: ==> Inherited Methods from Collection ++ Random access based on index ++ Iterators ++ Searching through index
		 *  
		 */
		// Sublist existing List | Partition of List
		Integer[] test ={1,2,3,4,8,2,13,53,23,89,808,34,25,55,65,6,2,4,8,9,1,2,5,6,77,80,3,3,32,2,5,6};
		List<Integer> lists = Arrays.asList(test);
		lists.subList(0, 5).stream().collect(Collectors.toList()).forEach(System.out::println);
	 // COmparable Interface==> Natural Sort Order
		System.out.println("--Comparible-ASC-----------");
		
		Collections.sort(lists);
		lists.stream().forEach(System.out::println);

		System.out.println("--Comparible-DESC-----------");

		Collections.reverse(lists);
		lists.stream().forEach(System.out::println);


		System.out.println("--Comparator-our own way of sorting-----------");

		Collections.sort(lists, new Comparator<Integer>() {

			@Override
			public int compare(Integer a,Integer b){  
				return a.compareTo(b);
			}
		});
		lists.stream().forEach(System.out::println);

		System.out.println("--JAVA8 way Comparator-our own way of sorting-----------");
		Collections.sort(lists,(a,b)->a.compareTo(b));
		lists.stream().forEach((p)->System.out.println(p));
		
		System.out.println("---------QUEUE-----");
		/****
		 * Queue Interface
		 *  :: ==> Inherited Methods from Collection ++ Additional insertion/removal/inspection operations
		 *  ==> Each method exists in two forms 1) return Exception if operation fails(add,remove,element) 2) return specific value or false(offer,poll,peek)
		 *	Typically FIFO order
		 *
		 * Deque = Queue + both ways of implementations
		 *
		 */

		System.out.println("--------MAP------");
		/****
		 * MAP Interface(<--HashMap,LinkedHashMap,TreeMap which are analogous to SET) => No duplicate Keys
		 *  keySet=> only keys || values => only values || entrySet => set of (key,value) pairs
		 *  
		 */
		
		
		
		}
	
	
	

}
