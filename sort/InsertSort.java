package com.ds.sort;

public class InsertSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arrayIns = new ArrayIns(maxSize);
        arrayIns.insert(77);
        arrayIns.insert(99);
        arrayIns.insert(44);
        arrayIns.insert(55);
        arrayIns.insert(22);
        arrayIns.insert(88);
        arrayIns.insert(66);
        arrayIns.insert(33);
        arrayIns.insert(11);
        arrayIns.insert(00);
        arrayIns.display();
        arrayIns.insertSort();
        arrayIns.display();
    }
}
class ArrayIns {
    private long []a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        a[nElems++]=value;
    }
    public void display() {
        for(int i=0;i<nElems;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    public void insertSort() {
        int in,out;
        long temp;
        for(out=1;out<nElems;out++) {
            in=out;
            temp=a[out];
            while(in>0&&a[in-1]>temp) {
                a[in]=a[in-1];
                in--;
            }
            a[in]=temp;
        }
    }
}
