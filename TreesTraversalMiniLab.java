//Name: Timothy Pham
//Class Period: 7th


/*************************************
 * Mini-Lab: Tree Traversal
 *
 * Given a tree, create recursive print 
 * methods for each traversl pattern.
 *
 *	pre-, in-, & post- order
 *
 *************************************/

public class TreesTraversalMiniLab
{
		
	public static void main (String[] args) 
	{
		//Creating the Tree
		IntTreeNode overallRoot = new IntTreeNode(17);
		overallRoot.left = new IntTreeNode(41, new IntTreeNode(29), new IntTreeNode(6));
		overallRoot.right = new IntTreeNode(9, new IntTreeNode(81), new IntTreeNode(40));
		
		//CALL the 3 print methods using the overallRoot
		System.out.print("Pre Order: ");
		printPreOrder(overallRoot);
		System.out.print("\nIn Order: ");
		printInOrder(overallRoot);
		System.out.print("\nPost Order: ");
		printPostOrder(overallRoot);
	}
	
	public static void printPreOrder(IntTreeNode root){ //root, left, right
		/* Prints the given tree using the pre-order pattern
		 */
		if (root == null) //base case
		{
			return;
		}
		System.out.print(root.data + " "); //prints root
		printPreOrder(root.left); //recurs left first
		printPreOrder(root.right); //then recurs right
	}
	
	public static void printInOrder(IntTreeNode root){ //left, root, right
		/* Prints the given tree using the in-order pattern
		 */
		if (root == null) //base case
		{
			return;
		}
		printInOrder(root.left); //recurs left first
		System.out.print(root.data + " "); //prints root
		printInOrder(root.right); //then recurs right
		 
	}
	
	public static void printPostOrder(IntTreeNode root){
		/* Prints the given tree using the pre-order pattern
		 */
		if (root == null) //base case
		{
			return;
		}
		printPostOrder(root.left); //recurs left first
		printPostOrder(root.right); //then recurs right
		System.out.print(root.data + " "); //prints root
	}

}

class IntTreeNode
{
	public int data;            // data stored at this node
    public IntTreeNode left;    // reference to left subtree
    public IntTreeNode right;   // reference to right subtree
        
    // Constructs a leaf node with the given data.
    public IntTreeNode(int data) {
        this(data, null, null);
    }
                
    // Constructs a branch node with the given data and links.
    public IntTreeNode(int data, IntTreeNode left,
                                 IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}