/*
 * LinkedListReplicated.java
 * 
 */

import java.io.File;
import java.io.IOException;

public class LinkedListReplicated  {
 
    public static void main(String s[]) 
    {	
		//Students create 2 LinkedIntList objects.
    		// a) Uses the default constructor
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	LinkedIntList listA = new LinkedIntList();
    	LinkedIntList listB = new LinkedIntList(11);
    	
      	//Test out each of your various methods (add, insert, get, indexOf, remove, size, toString)) 
      		//using either of the instantiated LinkedIntList objects
    	listA.add(42);
    	listA.add(5);
    	listA.add(12);
    	listA.add(2,25);
    	System.out.println("Before remove: " + listA.toString());
    	System.out.println("listA size = " + listA.size());
    	listA.remove(3);
    	System.out.println("After remove: " + listA.toString());
    	System.out.println("listA size = " + listA.size());
    	listA.add(31);
    	System.out.println("indexOf(5) = " + listA.indexOf(5));
    	System.out.println("indexOf(73) = " + listA.indexOf(73));
    	System.out.println("get(0) = " + listA.get(0));
    	System.out.println("listA = " + listA.toString());
    	listA.sort(); 
    	System.out.println("listA SORTED = " + listA.toString());
    	listA.clear(); 
    	System.out.println("listA CLEARED = " + listA.toString());
    	
    	System.out.println();
    	
    	listB.add(42);
    	listB.add(5);
    	listB.add(12);
    	listB.add(2,25);
    	System.out.println("Before remove: " + listB.toString());
    	System.out.println("listB size = " + listB.size());
    	listB.remove(3);
    	System.out.println("After remove: " + listB.toString());
    	System.out.println("listB size = " + listB.size());
    	listB.add(31);
    	System.out.println("indexOf(5) = " + listB.indexOf(25));
    	System.out.println("indexOf(73) = " + listB.indexOf(73));
    	System.out.println("get(0) = " + listB.get(0));
    	System.out.println("listB = " + listB.toString());
    	listB.sort(); 
    	System.out.println("listB SORTED = " + listB.toString());
    	listB.clear(); 
    	System.out.println("listB CLEARED = " + listB.toString());
    	
    }
    
	//Create your LinkedIntList class in another file called "LinkedIntList"
}
