package com.ds.sort;

public class SelectSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arraySel = new ArraySel(maxSize);
        arraySel.insert(77);
        arraySel.insert(99);
        arraySel.insert(44);
        arraySel.insert(55);
        arraySel.insert(22);
        arraySel.insert(88);
        arraySel.insert(66);
        arraySel.insert(33);
        arraySel.insert(11);
        arraySel.insert(00);
        arraySel.display();
        arraySel.selectSort();
        arraySel.display();
    }
}
class ArraySel {
    private long []a;
    private int nElems;

    public ArraySel(int max) {
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
    public void selectSort() {
        int in,out,min;
        for (out = 0;out<nElems-1;out++) {
            min=out;
            for(in = out;in<nElems;in++) {
                if(a[in]<a[min])
                    min=in;
            }
            swap(out,min);
        }
    }
    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}