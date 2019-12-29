package com.ds.heap;

import java.io.*;

class Node {
    private int iData;

    public Node(int iData) {
        this.iData = iData;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }
}
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }
    public boolean isEmpty() {
        return currentSize==0;
    }
    public boolean insert(int key) {
        if(currentSize==maxSize) return false;
        Node newNode = new Node(key);
        heapArray[currentSize]=newNode;
        trickleUp(currentSize++);//Upward Screening
        return true;
    }
    public void trickleUp(int index) {
        int parent = (index-1)/2;
        Node bottom = heapArray[index];
        while (index>0&&heapArray[parent].getiData()<bottom.getiData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index-1)/2;
        }
        heapArray[index] = bottom;
    }
    public Node remove() {//delete(assume non-empty list)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    public void trickleDown(int index) {//Downward Screening
        int largerChild;
        Node top = heapArray[index];//save root
        while (index<currentSize/2) {
            int leftChild = 2*index+1;
            int rightChild = 2*index+2;
            if (rightChild < currentSize && heapArray[leftChild].getiData() < heapArray[rightChild].getiData())
                largerChild = rightChild;
            else largerChild = leftChild;
            if (top.getiData()>=heapArray[largerChild].getiData()) break;
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    public boolean change(int index,int newValue) {
        if(index<0 || index >= currentSize) return false;
        int oldValue = heapArray[index].getiData();
        heapArray[index].setiData(newValue);
        if(oldValue < newValue) trickleUp(index);
        else trickleDown(index);
        return true;
    }
    public void display() {
        System.out.print("heapArray: ");
        for (int m=0; m < currentSize; m++)
            if(heapArray[m] != null) System.out.print(heapArray[m].getiData()+" ");
            else System.out.print("--");
        System.out.println("");
        int nBlank = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "*****************";
        System.out.println(dots+dots);
        while (currentSize > 0) {
            if(column == 0)
                for (int k=0; k<nBlank; k++)
                    System.out.print(" ");
            System.out.print(heapArray[j].getiData());
            if(++j==currentSize) break;
            if(++column==itemsPerRow) {
                nBlank /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println("");
            }
            else for (int k=0; k<nBlank*2-2; k++)
                System.out.print(" ");
        }
        System.out.print("\n"+dots+dots);
    }
}
class HeapApp {
    public static void main(String[] args) {
        int value1,value2;
        Heap heap = new Heap(31);
        boolean success;
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);
        heap.display();
        heap.insert(53);
        heap.display();
        heap.remove();
        heap.display();
        heap.change(0,200);
        heap.display();
    }
//    public static String getString()throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s=br.readLine();
//        return s;
//    }
//    public static char getChar()throws IOException {
//        String s=getString();
//        return s.charAt(0);
//    }
//    public static int getInt()throws IOException {
//        String s= getString();
//        return Integer.parseInt(s);
//    }
}

