package com.company;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    /*
            1
           / \
          2   3
         / \
        4   5
           /
          6
     */

    public static void main(String[] args) {
	    Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

	    BinaryTreeImpl obj = new BinaryTreeImpl();
        System.out.println("Number of Leaf Node  " + obj.countLeaf(root));
        System.out.println("Height of Tree " + obj.height(root));
        System.out.println("Sum of Tree " + obj.sumOfTree(root));
        System.out.println("Count of Non Leaf " + obj.countNonLeaf(root));
        System.out.println("Level of Node "  + obj.level(root, 4, 0));
        System.out.print("Level Order Traversal ");
        obj.levelOrderTraversal(root);
        System.out.println();
        System.out.print("Reverse Level Order Traversal ");
        obj.printReverseLevelOrderTraversal(root);
        System.out.println();
        System.out.print("Spiral Order Traversal ");
        obj.printSpiralLevelOrderTraversal(root);
        System.out.println();
        System.out.println("Sum of Left Leaf " + obj.sumOfLeftLeaf(root));
        System.out.print("Left view of tree is ");
        obj.printLeftView(root, 1);
        System.out.println();
        System.out.println("Root to leaf Path");
        obj.printRootToLeaf(root, new int[1000], 0);
        System.out.print("Root to Leaf Shortest Path ");
        obj.printRootToLeafShortest(root);
        System.out.println("TOP view of tree");
        obj.printTopView(root);

    }
}
