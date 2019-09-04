package com.company;

import java.util.*;

/**
 * @author Harneet
 */
public class BinaryTreeImpl implements BinaryTree{

    static int maxLevelLeft = 0;
    static int maxLevelRight = 0;

    @Override
    public int height(Node temp) {
        if(temp == null)
            return 0;
        return 1 + Math.max(height(temp.left), height(temp.right));
    }

    @Override
    public int level(Node temp, int x, int level) {
        if(temp == null)
            return 0;
        if(temp.data == x)
            return level;
        int downlevel = level(temp.left, x, level+1);
        if(downlevel != 0)
            return downlevel;
        downlevel = level(temp.right, x, level+1);
        return downlevel;
    }

    @Override
    public void levelOrderTraversal(Node temp) {

        if(temp == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()){
            Node temp1 = q.poll();
            System.out.print(temp1.data + " ");
            if(temp1.left != null)
                q.add(temp1.left);
            if(temp1.right != null)
                q.add(temp1.right);
        }
    }

    @Override
    public void inorderTraversal(Node temp) {

        if(temp == null)
            return;
        inorderTraversal(temp.left);
        System.out.print(temp.data + " ");
        inorderTraversal(temp.right);
    }

    @Override
    public int countLeaf(Node temp) {

        if(temp == null)
            return 0;
        if(temp.left == null && temp.right == null)
            return 1;
        return countLeaf(temp.left) + countLeaf(temp.right);

    }

    @Override
    public int countNonLeaf(Node temp) {

        if(temp == null || (temp.left == null && temp.right == null))
            return 0;
        return 1 + countNonLeaf(temp.left) + countNonLeaf(temp.right);
    }

    @Override
    public int width(Node temp) {
        return 0;
    }

    @Override
    public int sumOfTree(Node temp) {
        if(temp == null)
            return 0;
        return sumOfTree(temp.left) + temp.data + sumOfTree(temp.right);
    }

    @Override
    public int sumOfLeftLeaf(Node temp) {
        int res = 0;
        if(temp != null){
            if(isLeaf(temp.left))
                res = res + temp.left.data;
            else
                res += sumOfLeftLeaf(temp.left);
            res += sumOfLeftLeaf(temp.right);
        }
        return res;
    }

    @Override
    public void printLeftView(Node temp, int level) {
        if(temp == null)
            return;
        if(maxLevelLeft < level){
            System.out.print(temp.data + " ");
            maxLevelLeft = level;
        }
        printLeftView(temp.left, level + 1);
        printLeftView(temp.right, level + 1);
    }

    @Override
    public void printRightView(Node temp, int level) {

        if(temp == null)
            return;
        if(maxLevelRight < level){
            System.out.print(temp.data + " ");
            maxLevelRight = level;
        }
        printRightView(temp.right, level+1);
        printRightView(temp.left, level+1);
    }

    @Override
    public void printTopView(Node temp) {

        if(temp == null)
            return;
        class NodeObj{
            Node node;
            int hd;
            NodeObj(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<NodeObj> q = new LinkedList<>();
        q.add(new NodeObj(temp, 0));
        Map<Integer, Node> map = new TreeMap<>();
        while (!q.isEmpty()){
            NodeObj t = q.poll();
            if(!map.containsKey(t.hd))
                map.put(t.hd, t.node);
            if(t.node.left != null)
                q.add(new NodeObj(t.node.left, t.hd-1));
            if(t.node.right != null)
                q.add(new NodeObj(t.node.right, t.hd+1));
        }
        for(Map.Entry<Integer, Node> entry: map.entrySet()){
            System.out.print(entry.getValue().data + " ");
        }
    }

    @Override
    public void printLevelOrderTraversalLine(Node temp) {

        if(temp == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        q.add(null);
        while (!q.isEmpty()){
            Node temp1 = q.poll();
            if(temp1 == null){
                if(!q.isEmpty()){
                    q.add(null);
                    System.out.println();
                }
            }
            else if (temp1.left != null)
                q.add(temp1.left);
            else
                q.add(temp1.right);
            System.out.println(temp1.data);
        }
    }

    @Override
    public void printReverseLevelOrderTraversal(Node temp) {

        if(temp == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        Stack<Node> s = new Stack<>();

        while (!q.isEmpty()){
            Node temp1 = q.poll();
            s.push(temp1);
            if(temp1.right != null)
                q.add(temp1.right);
            if(temp1.left != null)
                q.add(temp1.left);
        }
        while (!s.isEmpty()){
            System.out.print(s.pop().data + " ");
        }
    }

    @Override
    public void printSpiralLevelOrderTraversal(Node temp) {

        if(temp == null)
            return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(temp);

        while (!s1.isEmpty() || !s2.isEmpty()){

            while (!s1.isEmpty()){
                Node temp1 = s1.pop();
                System.out.print(temp1.data + " ");
                if(temp1.right != null)
                    s2.push(temp1.right);
                if(temp1.left != null)
                    s2.push(temp1.left);
            }
            while (!s2.isEmpty()){
                Node temp1 = s2.pop();
                System.out.print(temp1.data + " ");
                if(temp1.left != null)
                    s1.push(temp1.left);
                if(temp1.right != null)
                    s1.push(temp1.right);
            }
        }
    }

    @Override
    public boolean isSibling(Node temp, int x, int y) {
        if(temp == null)
            return false;
        return ((temp.left.data == x && temp.right.data == y) || (temp.left.data == y && temp.right.data == x) || isSibling(temp.left, x, y) || isSibling(temp.right, x, y));
    }

    @Override
    public int isSumTree(Node temp) {
        if(temp == null ||(temp.left == null && temp.right == null))
            return 1;
        int ls = sum(temp.left);
        int rs = sum(temp.right);
        if((ls + rs == temp.data) && (isSumTree(temp.left)!=0 && isSumTree(temp.right) != 0))
            return 1;
        return 0;
    }
    @Override
    public int sum(Node temp){
        if(temp == null)
            return 0;
        return sum(temp.left) + temp.data + sum(temp.right);
    }

    @Override
    public boolean isPerfectTree(Node temp, int d, int level) {
        if (temp == null)
            return true;
        if (temp.left == null && temp.right == null)
            return (d == level + 1);
        if (temp.left == null || temp.right == null)
            return false;
        return (isPerfectTree(temp.left, d, level + 1) && isPerfectTree(temp.right, d, level + 1));
    }
    @Override
    public boolean isLeaf(Node temp){
        if(temp == null)
            return false;
        if(temp.left == null && temp.right == null)
            return true;
        return false;
    }

    @Override
    public void printRootToLeaf(Node temp, int[] list, int ptr){
        if(temp == null)
            return;
        list[ptr] = temp.data;
        ptr++;
        if(temp.left == null && temp.right == null){
            for(int i = 0; i < ptr; i++){
                System.out.print(list[i]);
            }
            System.out.println();
        }
        printRootToLeaf(temp.left, list, ptr);
        printRootToLeaf(temp.right, list, ptr);
    }
    @Override
    public void printRootToLeafShortest(Node temp){
        class ObjNode{
            Node node;
            ArrayList<Integer> list;
            ObjNode(Node node, ArrayList<Integer> list){
                this.node = node;
                this.list = list;
            }
        }
        if(temp == null)
            return;
        Queue<ObjNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(temp.data);
        q.add(new ObjNode(temp, list));
        while (!q.isEmpty()){
            ObjNode t = q.poll();
            if(t.node.left == null && t.node.right == null){
                for(int i = 0; i < t.list.size(); i++){
                    System.out.print(t.list.get(i) + " ");
                }
                break;
            }
            if(t.node.left != null){
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.addAll(t.list);
                list1.add(t.node.left.data);
                q.add(new ObjNode(t.node.left, list1));
            }

            if(t.node.right != null){
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.addAll(t.list);
                list1.add(t.node.right.data);
                q.add(new ObjNode(t.node.right, list1));
            }

        }
    }
}
