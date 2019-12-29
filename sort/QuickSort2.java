package com.ds.sort;

//三数据划分
public class QuickSort2 {
    public static void main(String[] args) {
        int maxSize=16;
        ArrayIn2 array = new ArrayIn2(maxSize);
        for (int j=0;j<maxSize;j++) {
            long n=(long)(Math.random()*99);
            array.insert(n);
        }
        array.display();
        array.quickSort();
        array.display();
    }
}
class ArrayIn2 {
    private long []array;
    private int nElems;
    public ArrayIn2(int max) {
        array = new long[max];
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
        int size=right-left+1;
        if(size<3) manualSort(left,right);
        else {
            long median = medianOf(left,right);
            int partition = partitionIt(left,right,median);
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }
    }
    public void manualSort(int left,int right) {
        int size=right-left+1;
        if(size<=1) return;
        if(size==2) {
            if (array[left]>array[right]) swap(left,right);
            return;
        }
        else {
            if(array[left]>array[right-1]) swap(left,right-1);
            if(array[left]>array[right]) swap(left,right);
            if(array[right-1]>array[right]) swap(right-1,right);
        }
    }
    public long medianOf(int left,int right) {
        int center = (left+right)>>1;
        if(array[left]>array[center]) swap(left,center);
        if(array[left]>array[right]) swap(left,right);
        if(array[center]>array[right]) swap(center,right);
        swap(center,right-1);
        return array[right-1];
    }
    public int partitionIt(int left,int right,long pivot) {
        int leftPtr=left;
        int rightPtr=right-1;
        while (true) {
            while (array[++leftPtr]<pivot);
            while(array[--rightPtr]>pivot);
            if(leftPtr>=rightPtr) break;
            else swap(leftPtr,rightPtr);
        }
        swap(leftPtr,right-1);
        return leftPtr;
    }
    public void swap(int a,int b) {
        long temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
