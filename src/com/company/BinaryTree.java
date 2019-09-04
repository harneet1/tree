package com.company;

import java.util.ArrayList;

/**
 * @author Harneet
 */
public interface BinaryTree {

    int height(Node temp);
    int level(Node temp1, int x, int level);
    void levelOrderTraversal(Node temp);
    void inorderTraversal(Node temp);
    int countLeaf(Node temp);
    int countNonLeaf(Node temp);
    int width(Node temp);
    int sumOfTree(Node temp);
    int sumOfLeftLeaf(Node temp);
    void printLeftView(Node temp, int level);
    void printRightView(Node temp, int level);
    void printTopView(Node temp);
    void printbottomView(Node temp);
    void printLevelOrderTraversalLine(Node temp);
    void printReverseLevelOrderTraversal(Node temp);
    void printSpiralLevelOrderTraversal(Node temp);
    boolean isSibling(Node temp, int x, int y);
    int isSumTree(Node temp);
    int sum(Node temp);
    boolean isPerfectTree(Node temp, int height, int level);
    boolean isLeaf(Node temp);
    void printRootToLeaf(Node temp, int[] list, int ptr);
    void printRootToLeafShortest(Node temp);

}
