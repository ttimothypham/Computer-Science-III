import java.io.PrintStream;

public class AVLTreeTester {

  public static void main(String args[]) {
    SearchTree<Integer> bst = new SearchTree<>();
    BinaryTreePrinter<Integer> printer1 = new BinaryTreePrinter<>();
    bst.add(5);
    bst.add(3);
    bst.add(1);
    bst.add(2);
    System.out.println("Generic BST:");
    System.out.println(bst + "\n");
    printer1.printPreOrder(System.out, bst.overallRoot);
    // Tree should look like:
    //      5
    //     /
    //    3
    //   /
    //  1
    //   \
    //    2

    AVLTree<Integer> avl = new AVLTree<>();
    BinaryTreePrinter<Integer> printer2 = new BinaryTreePrinter<>();
    avl.insert(5);
    avl.insert(3);
    avl.insert(1);
    avl.insert(2);
    System.out.println("\nAVL tree:");
    System.out.println(avl + "\n");
    printer2.printPreOrder(System.out, avl.overallRoot);
    // Tree should look like:
    //       3
    //     /   \
    //    1     5
    //     \
    //      2

     /* Feel free to use your Collection constructor to recreate
     any example trees that we practiced with. */
    
    System.out.println();
    AVLTree<Integer> av2 = new AVLTree<>();
    BinaryTreePrinter<Integer> printer3 = new BinaryTreePrinter<>();
    av2.insert(12);
    av2.insert(18);
    av2.insert(8);
    av2.insert(11);
    av2.insert(17);
    av2.insert(5);
    av2.insert(4);
    System.out.println("\nAVL tree 2:");
    System.out.println(av2 + "\n");
    printer3.printPreOrder(System.out, av2.overallRoot);
    
    System.out.println();
    AVLTree<Integer> av3 = new AVLTree<>();
    BinaryTreePrinter<Integer> printer4 = new BinaryTreePrinter<>();
    av3.insert(40);
    av3.insert(30);
    av3.insert(20);
    av3.insert(60);
    av3.insert(50);
    av3.insert(80);
    av3.insert(15);
    av3.insert(28);
    av3.insert(25);
    System.out.println("\nAVL tree 3:");
    System.out.println(av3 + "\n");
    printer4.printPreOrder(System.out, av3.overallRoot);
     
  }
}

class BinaryTreePrinter<E>
{
  public void printPreOrder(PrintStream os, SearchTreeNode<E> overallRoot) {
    os.print(traversePreOrder(overallRoot));
  }

  private String traversePreOrder(SearchTreeNode<E> root) {

      if (root == null) {
          return "";
      }

      StringBuilder sb = new StringBuilder();
      sb.append(root.data);
      
      String pointerRight ="[R]--";
      String pointerLeft = (root.right != null) ? "[L]--" : "[L]--";

      traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
      
      traverseNodes(sb, "", pointerRight, root.right, false);

      return sb.toString();
  }
  private void traverseNodes(StringBuilder sb, String padding, String pointer, SearchTreeNode<E> node, boolean hasRightSibling) {

      if (node != null) {

          sb.append("\n");
          sb.append(padding);
          sb.append(pointer);
          sb.append(node.data);

          StringBuilder paddingBuilder = new StringBuilder(padding);
          if (hasRightSibling) {
              paddingBuilder.append("|    ");
          } else {
              paddingBuilder.append("     ");
          }

          String paddingForBoth = paddingBuilder.toString();
          String pointerRight = "[R]--";
          String pointerLeft = (node.right != null) ? "[L]--" : "[L]--";

          traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
          traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);

      }

  }
}



