//BSTReplicated.java
//Timothy Pham
//Purpose: Create a file to test out my BinarySearchIntTree class
import java.io.File;
import java.io.IOException;


public class BSTReplicated  {
 
    public static void main(String s[]) 
    {
    	
		//Students create 2 BinarySearchInt objects.
    		// a) Uses the default constructor
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	BinarySearchIntTree treeA = new BinarySearchIntTree(55); //treeA: constructor w/ int parameter
    	System.out.println("treeA");
    	treeA.add(29);
    	treeA.add(87);
    	treeA.add(-3);
    	treeA.add(42);
    	treeA.add(60);
    	treeA.add(91);
    	System.out.println(treeA.toString());
    	System.out.println("REMOVE -3 (Leaf) = " + treeA.remove(-3));
    	System.out.println("CONTAINS -3 = " + treeA.contains(-3));
    	System.out.println(treeA.toString());
    	System.out.println("SMALLEST = " + treeA.smallest());
    	System.out.println("LARGEST = " + treeA.largest());
    	System.out.println("ADD -3 = " + treeA.add(-3));
    	System.out.println(treeA.toString());
    	System.out.println("REMOVE 55 (Overall Root (Root w/ Both Kids)) = " + treeA.remove(55));
    	System.out.println(treeA.toString());
    	System.out.println("Current Size: " + treeA.getSize());
    	System.out.println("REMOVE 87 (Parent w/ only kid @ right) = " + treeA.remove(87));
    	System.out.println(treeA.toString());
    	System.out.println("REMOVE 42 (Leaf) = " + treeA.remove(42));
    	System.out.println(treeA.toString());
    	System.out.println("REMOVE 29 (Parent w/ only kid @ left) = " + treeA.remove(29));
    	System.out.println(treeA.toString());
    	System.out.println("CONTAINS 91 = " + treeA.contains(91));
    	System.out.println("CONTAINS 44 = " + treeA.contains(44));
    	System.out.println("Number of leaves: " + treeA.countLeaves());
    	System.out.println("REMOVE 60 = " + treeA.remove(60));
    	System.out.println(treeA.toString());
    	System.out.println("ADD -3 (Dupe) = " + treeA.add(-3));
    	System.out.println("Number of leaves: " + treeA.countLeaves());
    	treeA.clear();
    	System.out.println("Clear() : " + treeA.toString());
    	
    	System.out.println();
    	System.out.println("=================================================================================");
    	
    	System.out.println("\ntreeB");
    	BinarySearchIntTree treeB = new BinarySearchIntTree(); //treeB: default constructor
    	treeB.add(29);
    	treeB.add(87);
    	treeB.add(-3);
    	treeB.add(42);
    	treeB.add(60);
    	treeB.add(91);
    	System.out.println(treeB.toString());
    	System.out.println("REMOVE -3 (Leaf) = " + treeB.remove(-3));
    	System.out.println("CONTAINS -3 = " + treeB.contains(-3));
    	System.out.println(treeB.toString());
    	System.out.println("SMALLEST = " + treeB.smallest());
    	System.out.println("LARGEST = " + treeB.largest());
    	System.out.println("ADD -3 = " + treeB.add(-3));
    	System.out.println(treeB.toString());
    	System.out.println("REMOVE 55 (Overall Root (Root w/ Both Kids)) = " + treeB.remove(55));
    	System.out.println(treeB.toString());
    	System.out.println("Current Size: " + treeB.getSize());
    	System.out.println("REMOVE 87 (Parent w/ only kid @ right) = " + treeB.remove(87));
    	System.out.println(treeB.toString());
    	System.out.println("REMOVE 42 (Leaf) = " + treeB.remove(42));
    	System.out.println(treeB.toString());
    	System.out.println("REMOVE 29 (Parent w/ only kid @ left) = " + treeB.remove(29));
    	System.out.println(treeB.toString());
    	System.out.println("CONTAINS 91 = " + treeB.contains(91));
    	System.out.println("CONTAINS 44 = " + treeB.contains(44));
    	System.out.println("Number of leaves: " + treeB.countLeaves());
    	System.out.println("REMOVE 60 = " + treeB.remove(60));
    	System.out.println(treeB.toString());
    	System.out.println("ADD -3 (Dupe) = " + treeB.add(-3));
    	System.out.println("Number of leaves: " + treeB.countLeaves());
    	treeB.clear();
    	System.out.println("Clear() : " + treeB.toString());
    	
      	//Test out each of your various methods (getSize, clear, isEmpty, add, findParent, contains, remove, toString)) 
      		//using either of the instantiated BinarySearchIntTree objects
      		
    }
    
	//Create your BinarySearchIntTree class in another file called "BinarySearchIntTree"
}


