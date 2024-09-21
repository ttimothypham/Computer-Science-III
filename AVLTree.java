//Timothy Pham
//Purpose: Create a functional AVLTree class with a working insert and remove method
public class AVLTree <E extends Comparable<E>> extends SearchTree<E>{
    
    public boolean add(E data)
    {
        return insert(data);
    }

    public boolean insert(E data)
    {
        // This method should use a recursive helper.  It returns
    	// the tree that results from inserting data 
    	// into t. It has a similar structure to add from BST.  It
    	// starts by asking if tree is empty, and if so it sets the
    	// a new leaf node as the root. If tree is not empty you can compare
    	// data to the current node's data and take action based on this comparison.
    	// When you create a new leaf node you should 
		// increment the tree's size variable. When you return from a 
    	// recursive call that updates one of t's children
    	// (e.g. curr.leftChild = insertHelper(data, curr.left))
		// you should check the AVL property and possibly 
    	// call updateHeight(), and then recompute curr's height.
    	overallRoot = insertHelper((AVLNode<E>) overallRoot, data); //Calls the private insert method to insert a new node while first traversing at the overall root
    	return true;
    }
    
    private AVLNode<E> insertHelper(AVLNode<E> root, E data)
    {
    	if (root == null) //checks if current node is null
    	{
    		root = new AVLNode<E>(data); //inserts the new node
    		root.updateHeight(); //update height
    		size++; //increment size
    		return root;
    	}
    	else if (data.compareTo(root.data) < 0) //checks if the data is less than the current root, if so go left
    	{
    		root.left = insertHelper((AVLNode<E>)root.left, data); //recurs to insert the node on the left side
    	}
    	else //goes right because data is greater than current root
    	{
    		root.right = insertHelper((AVLNode<E>)root.right, data); //recurs to insert the node on the right side
    	}
    	
    	root.updateHeight(); //update height
    	
    	if (root.bf() < -1) //checks if tree is left heavy
    	{
    		if (data.compareTo(root.left.data) < 0) //checks to see if a left-right rotation is necessary
    		{
    			return rotateRight(root); //calls to rotate broken node right
    		}
    		else //left-right rotation bc not same side heavy
    		{
    			root.left = rotateLeft((AVLNode<E>) root.left); //calls to rotate broken node left
    			return rotateRight(root); //calls to rotate broken node right
    		}
    	}
    	else if (root.bf() > 1) //checks if tree is right heavy
    	{
    		if (data.compareTo(root.right.data) > 0) //checks to see if a right-left rotation is necessary
    		{
    			return rotateLeft(root); //calls to rotate broken node left
    		}
    		else
    		{
    			root.right = rotateRight((AVLNode<E>) root.right); //calls to rotate broken node right
    			return rotateLeft(root); //calls to rotate broken node left
    		}
    	}

    	return (AVLNode<E>) root;
    }

    // TODO: IMPLEMENT THE FOLLOWING METHODS BASED ON THE JAVADOC COMMENTS
  
    /**
     * Perform a single rotation to the right of a tree rooted at the current node.
     * Consider the following illustrations (called on the node A):
     *
     *        A       =>     B
     *       / \      =>    / \
     *      B   T3    =>  T1   A
     *     / \        =>      / \
     *   T1   T2      =>    T2   T3
     *
     * Note that A's original parent (if it exists) will need to become B's new
     * parent. 
     *
     * @return The new root of this subtree (node B).
     */
    public AVLNode<E> rotateRight(AVLNode<E> oldRoot) {
        // TODO: Implement this method.  Return the new root B.
        // Do not forget to change A's parent (if it exists) to be
        // aware of B as the new root by returning the new root and setting the
        // parent's pointer when we call rotateRight(node).
    	
    	AVLNode<E> newRoot = (AVLNode<E>) oldRoot.left; //sets the new root to the broken node's left
    	AVLNode<E> repoRoot = (AVLNode<E>) newRoot.right; //sets repoRoot to the node that will be repositioned IF NECESSARY
    	newRoot.right = oldRoot; //points the new root's right to the old root
    	oldRoot.left = repoRoot; //points old root's left to the repo root
    	//update the height so that the AVL tree can recognize that the rotation made the subtree balanced
    	oldRoot.updateHeight(); 
    	newRoot.updateHeight();
    	return newRoot; 
    }

    /**
     * Perform a single rotation to the left of a tree rooted at the current node.
     * Consider the following illustrations (called on the node A):
     *
     *      A         =>       B
     *     / \        =>      / \
     *   T1   B       =>     A   T3
     *       / \      =>    / \
     *     T2   T3    =>  T1   T2
     *
     * Note that A's original parent (if it exists) will need to become B's new
     * parent. 
     *
     * @return The new root of this subtree (node B).
     */
    public AVLNode<E> rotateLeft(AVLNode<E> OldRoot) {
        // TODO: Implement this method. Return the new root B. 
        // Do not forget to change A's parent (if it exists) to be
        // aware of B as the new root by returning the new root and setting the
        // parent's pointer when we call rotateRight(node).
        
    	AVLNode<E> newRoot = (AVLNode<E>) OldRoot.right; //sets the new root to the broken node's right
    	AVLNode<E> repoRoot = (AVLNode<E>) newRoot.left; //sets repoRoot to the node that will be repostioned IF NECESSARY
    	newRoot.left = OldRoot; //points the new root's left to the old root
    	OldRoot.right = repoRoot; //points old root's right to the repo root
    	//update the height so that the AVL tree can recognize that the rotation made the subtree balanced
    	OldRoot.updateHeight();
    	newRoot.updateHeight();
    	return newRoot;
    }

    
    public boolean remove(E data)
    {
        int initialSize = size;
        removeHelper((AVLNode<E>) overallRoot, data);
        if (initialSize > size)
        { return true; }
        return false;
    }
    
    private AVLNode<E> removeHelper(AVLNode<E> node, E data)
    {
    	if (node == null)
    	{
    		return node;
    	}
    	else if (data.compareTo(node.data) < 0) //checks if the data is less than the current root, if so go left
    	{
    		node.left = removeHelper((AVLNode<E>) node.left, data);
    		return node;
    	}
    	else if (data.compareTo(node.data) > 0) //checks if the data is greater than the current root, if so go right
    	{
    		node.right = removeHelper((AVLNode<E>) node.right, data);
    		return node;
    	}
    	else //reached designated node to remove
    	{
    		if (node.left == null && node.right == null)
    		{
    			node = null;
    			size--;
    		}
    		else if (node.left != null && node.right == null) //case: node with left child only
			{
				AVLNode<E> successor = (AVLNode<E>) node.left; //replaced with left child
				node.left= null; //remove the left child since it is replacing the target node
				size--;
				node = successor;
				return node;
			}
			else if (node.left == null && node.right != null) //case: node with right child only
			{
				AVLNode<E> successor = (AVLNode<E>) node.right; //replaced with right child
				node.right = null; //remove the right child since it is replacing the target node
				size--;
				node = successor;
				return node;
			}
			else if (node.left != null && node.right != null) //case: node has both children
			{
				AVLNode<E> successor = (AVLNode<E>) minNode(node.right); //finds the successor (minNode of the right side)
				AVLNode<E> repoNode = (AVLNode<E>) node.left; //variable for left node that will be reconnected to the successor
				node.data = successor.data; //replace the target node with the successor
				node.right = removeHelper((AVLNode<E>) node.right, successor.data); //remove the successor node since it replaced the target node
				node.left = repoNode; //reconnect the repoNode
				size--;
				return node;
			}
    	}
    	
    	//checks to make sure node is not null to proceed to update and check the balance of tree
    	//if it is null it will return node here and not check the balance of the tree
    	if (node == null) 
    	{
    		return node;
    	}
    	
    	node.updateHeight(); //update height
    	
    	if (node.bf() < -1) //checks if tree is left heavy
    	{
    		if (data.compareTo(node.left.data) < 0) //checks to see if a left-right rotation is necessary
    		{
    			return rotateRight(node); //calls to rotate broken node right
    		}
    		else //left-right rotation bc not same side heavy
    		{
    			node.left = rotateLeft((AVLNode<E>) node.left); //calls to rotate broken node left
    			return rotateRight(node); //calls to rotate broken node right
    		}
    	}
    	else if (node.bf() > 1) //checks if tree is right heavy
    	{
    		if (data.compareTo(node.right.data) > 0) //checks to see if a right-left rotation is necessary
    		{
    			return rotateLeft(node); //calls to rotate broken node left
    		}
    		else
    		{
    			node.right = rotateRight((AVLNode<E>) node.right); //calls to rotate broken node right
    			return rotateLeft(node); //calls to rotate broken node left
    		}
    	}
    	
    	return node;
    	
    }

    // This will help you with debugging. It prints the keys
   // on each level of the tree.
   public void treePrinter() {
    for (int level = 0; level < ((AVLNode<E>)overallRoot).height(); level++ ) {
        System.out.printf("Level %d: ", level);
        printLevel(level, (AVLNode<E>)overallRoot);
        System.out.println();
    }
}

    public void printLevel(int level, AVLNode<E> t) {
        if (t != null) {
            if (level == 0)
                System.out.printf(  "%s ", t.data);
            else {
                printLevel(level-1, (AVLNode<E>)t.left);
                printLevel(level-1, (AVLNode<E>)t.right);
            }
        }
    }
}






