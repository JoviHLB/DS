package com.ds.sort;

//递归
public class QuickSort1 {
    public static void main(String[] args) {
        int maxSize=16;
        ArrayIn array = new ArrayIn(maxSize);
        for (int j=0;j<maxSize;j++) {
            long n=(long)(Math.random()*99);
            array.insert(n);
        }
        array.display();
        array.quickSort();
        array.display();
    }
}
class ArrayIn {
    private long []array;
    private int nElems;
    public ArrayIn(int max) {
        array=new long[max];
        nElems=0;
    }
    public void insert(long value) {
        array[nElems++]=value;
    }
    public void display() {
        System.out.print("A=");
        for (int j=0;j<nElems;j++)
            System.out.print(array[j]+" ");
        System.out.println("");
    }
    public void quickSort() {
        recQuickSort(0,nElems-1);
    }
    public void recQuickSort(int left,int right) {
        if(right-left<=0) return;
        else {
            long pivot=array[right];
            int partition = partitionIt(left,right,pivot);
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }
    }
    public int partitionIt(int left,int right,long pivot) {
        int leftPtr=left-1;
        int rightPtr=right;
        while (true) {
            while (array[++leftPtr]<pivot);
            while(rightPtr>0&&array[--rightPtr]>pivot);
            if(leftPtr>=rightPtr) break;
            else swap(leftPtr,rightPtr);
        }
        swap(leftPtr,right);
        return leftPtr;
    }
    public void swap(int a,int b) {
        long temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
