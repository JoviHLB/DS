package com.ds.heap;
import java.io.*;

class Node1 {
    private int iData;
    public Node1(int key) {
        iData = key;
    }
    public int getKey() {
        return iData;
    }
    public void setKey(int key) {
        iData = key;
    }
}
class Heap1 {
    private Node1[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap1(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node1[maxSize];
    }
    public Node1 remove() { //delete(assume non-empty list)
        Node1 root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    public void trickleDown(int index) {//Downward Screening
        int largerChild;
        Node1 top = heapArray[index];//save root
        while (index<currentSize/2) {
            int leftChild = 2*index+1;
            int rightChild = 2*index+2;
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else largerChild = leftChild;
            if (top.getKey()>=heapArray[largerChild].getKey()) break;
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    public void display() {
        System.out.print("heapArray: ");
        for (int m=0; m < currentSize; m++)
            if(heapArray[m] != null) System.out.print(heapArray[m].getKey()+" ");
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
            System.out.print(heapArray[j].getKey());
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
    public void displayArray() {
        for (int j=0; j<currentSize; j++) {
            System.out.print(heapArray[j].getKey()+" ");
        }
        System.out.println("");
    }
    public void insertAt(int index,Node1 newNode) {
        heapArray[index] = newNode;
    }
    public void incrementSize() {
        currentSize++;
    }
}
public class HeapSort {
    public static void main(String[] args) throws IOException {
        int size,j;
        System.out.println("Enter number of items:");
        size = getInt();
        Heap1 heap1 = new Heap1(size);
        for (j=0; j<size; j++) {
            int random = (int)(Math.random()*100);
            Node1 newNode = new Node1(random);
            heap1.insertAt(j,newNode);
            heap1.incrementSize();
        }
        System.out.println("Random: ");
        heap1.displayArray();
        for (j=size/2-1; j>=0; j--)
            heap1.trickleDown(j);
        System.out.println("Heap: ");
        heap1.displayArray();
        heap1.display();
        for (j=size-1; j>=0; j--) {
            Node1 bigNode = heap1.remove();
            heap1.insertAt(j,bigNode);

        }
        System.out.print("\n Sort:  ");//display sorted array
        for(j=0; j<size; j++) heap1.incrementSize();
        heap1.displayArray();
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
