package com.company;

import java.util.ArrayList;

/**
 * @author Harneet
 */
public interface BinaryTree {

    public int height(Node temp);
    public int level(Node temp1, int x, int level);
    public void levelOrderTraversal(Node temp);
    public void inorderTraversal(Node temp);
    public int countLeaf(Node temp);
    public int countNonLeaf(Node temp);
    public int width(Node temp);
    public int sumOfTree(Node temp);
    public int sumOfLeftLeaf(Node temp);
    public void printLeftView(Node temp, int level);
    public void printRightView(Node temp);
    public void printTopView(Node temp);
    public void printLevelOrderTraversalLine(Node temp);
    public void printReverseLevelOrderTraversal(Node temp);
    public void printSpiralLevelOrderTraversal(Node temp);
    public boolean isSibling(Node temp, int x, int y);
    public int isSumTree(Node temp);
    public int sum(Node temp);
    public boolean isPerfectTree(Node temp, int height, int level);
    public boolean isLeaf(Node temp);
    public void printRootToLeaf(Node temp, int[] list, int ptr);
    public void printRootToLeafShortest(Node temp);

}
