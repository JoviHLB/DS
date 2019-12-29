package com.ds.tree;

import java.io.*;
import java.util.Stack;

public class Tree {
    private Node root;
    public Tree() {
        root=null;
    }
    public Node find(int key) {
        Node current = root;
        while (current.iData!=key) {
            if(key<current.iData) current=current.leftChild;
            else current= current.rightChild;
            if(current==null) return null;
        }
        return current;
    }
    public void insert(int i,double d) {
        Node newNode = new Node();
        newNode.iData=i;
        newNode.dData=d;
        if(root==null) root=newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent=root;
                if(i<current.iData) {
                    current=current.leftChild;
                    if(current==null) {
                        parent.leftChild=newNode;
                        return;
                    }
                }
                else {
                    current=current.rightChild;
                    if(current==null) {
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }
    public boolean delete(int key) {//略过完整代码
        Node current = root;
        Node parent = root;
        boolean isLeftChild=true;
        while(current.iData!=key) {
            parent=current;
            if(key<current.iData) {
                isLeftChild=true;
                current=current.leftChild;
            }
            else {
                isLeftChild=false;
                current=current.rightChild;
            }
            if(current==null)
                return false;
        }
        if(current.rightChild==null&&current.leftChild==null) {
            if(current==root)
                root=null;
            else if (isLeftChild)
                parent.leftChild=null;
            else
                parent.rightChild=null;
        }
        else if(current.rightChild==null)
            if(current==null)
                root=current.leftChild;
            else if(isLeftChild)
                parent.leftChild=current.leftChild;
            else
                parent.rightChild=current.leftChild;
        else if(current.leftChild==null)
            if(current==null)
                root=current.rightChild;
            else if(isLeftChild)
                parent.leftChild=current.rightChild;
            else
                parent.rightChild=current.rightChild;
        else {//3.删除点同时有两个子节点
            Node successor = getSuccessor(current);
            if(current==null) root=successor;
            else if(isLeftChild) parent.leftChild=successor;
            else parent.rightChild=successor;
            successor.leftChild=current.leftChild;
        }
        return true;
    }
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current!=null) {
            successorParent=successor;
            successor=current;
            current=current.leftChild;
        }
        if(successor!=delNode.rightChild) {
            successorParent.leftChild=successor.rightChild;
            successor.rightChild=delNode.rightChild;
        }
        return successor;
    }
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("");
                preOder(root);
            case 2:
                System.out.println("");
                inOder(root);
            case 3:
                System.out.println("");
                postOder(root);
                break;
        }
        System.out.println("");
    }
    public void preOder(Node localRoot) {
        if(localRoot!=null) {
            System.out.print(localRoot.iData+" ");
            preOder(localRoot.leftChild);
            preOder(localRoot.rightChild);
        }


    }
    public void inOder(Node localRoot) {
        if(localRoot!=null) {
            inOder(localRoot.leftChild);
            System.out.print(localRoot.iData+" ");
            inOder(localRoot.rightChild);
        }
    }
    public void postOder(Node localRoot) {
        if(localRoot!=null) {
            preOder(localRoot.leftChild);
            preOder(localRoot.rightChild);
            System.out.print(localRoot.iData+"");
        }
    }
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks=32;
        boolean isRowEmpty = false;
        System.out.println(".........................");
        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty=true;
            for(int j=0;j<nBlanks;j++) System.out.print(" ");
            while (!globalStack.isEmpty()) {
                Node temp = (Node)globalStack.pop();
                if(temp!=null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.rightChild!=null||temp.leftChild!=null)
                        isRowEmpty=false;
                }
                else {
                    System.out.print("..");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j=0;j<nBlanks*2-2;j++)
                    System.out.print(" ");
            }
            System.out.println("");
            nBlanks/=2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println("....................");
    }
}
class Node {
    public int iData;//(key)
    public double dData;
    public Node leftChild;
    public Node rightChild;
    public void display() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(",");
        System.out.print(dData);
        System.out.print("}");
    }
}
class TreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        Tree tree = new Tree();
        tree.insert(50,1.5);
        tree.insert(25,1.2);
        tree.insert(75,1.7);
        tree.insert(12,1.5);
        tree.insert(37,1.2);
        tree.insert(43,1.7);
        tree.insert(30,1.5);
        tree.insert(33,1.2);
        tree.insert(87,1.7);
        tree.insert(93,1.5);
        tree.insert(97,1.5);
        while (true) {
            System.out.print("Enter first letter of show,");
            System.out.print("insert,find,delete,or traverse: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if(found!=null) {
                        System.out.print("Found:");
                        found.display();
                        System.out.println("");
                    }
                    else {
                        System.out.print("Could not found");
                        System.out.println(value);
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete:");
                    value=getInt();
                    boolean didDelete = tree.delete(value);
                    if(didDelete)
                        System.out.println("Delete "+value);
                    else System.out.print("Could not delete");
                    System.out.println(value);
                    break;
                case 't':
                    System.out.print("Enter type1,2,or 3:");
                    value=getInt();
                    tree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
    public static String getString()throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
    public static char getChar()throws IOException {
        String s=getString();
        return s.charAt(0);
    }
    public static int getInt()throws IOException {
        String s= getString();
        return Integer.parseInt(s);
    }
}
