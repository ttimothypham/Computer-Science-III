/*
 * SLinkedListReplicated.java
 * 
 */

import java.io.File;
import java.io.IOException;

public class SLinkedListReplicated  {
 
    public static void main(String s[]) 
    {	
		//Students create 2 LinkedIntList objects.
    		// a) Uses the default constructor
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	SLinkedList<Integer> listA = new SLinkedList<Integer>();
    	SLinkedList<String> listB = new SLinkedList<String>("Bears");
    	SLinkedList<Character> listC = new SLinkedList<Character>();
    	
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
    	
    	System.out.println();
    	
    	listB.add("Win");
    	listB.add("The");
    	listB.add("Day");
    	listB.add(2,"Watson");
    	System.out.println("Before remove: " + listB.toString());
    	System.out.println("listB size = " + listB.size());
    	listB.remove(3);
    	System.out.println("After remove: " + listB.toString());
    	System.out.println("listB size = " + listB.size());
    	listB.add("Compsci Rocks");
    	System.out.println("indexOf(\"Watson\") = " + listB.indexOf("Watson"));
    	System.out.println("indexOf(\"R*plit\") = " + listB.indexOf("R*plit"));
    	System.out.println("get(0) = " + listB.get(0));
    	System.out.println("listB = " + listB.toString());
    	
    	System.out.println();
    	
    	listC.add('a');
    	listC.add('b');
    	listC.add('e');
    	listC.add(2,'c');
    	System.out.println("Before remove: " + listC.toString());
    	System.out.println("listC size = " + listC.size());
    	listC.remove(3);
    	System.out.println("After remove: " + listC.toString());
    	System.out.println("listC size = " + listC.size());
    	listC.add('e');
    	System.out.println("indexOf(\"b\") = " + listC.indexOf('b'));
    	System.out.println("indexOf(\"z\") = " + listC.indexOf('z'));
    	System.out.println("get(0) = " + listC.get(0));
    	System.out.println("listC = " + listC.toString());
    	
    }
    
	//Create your LinkedIntList class in another file called "LinkedIntList"
}
