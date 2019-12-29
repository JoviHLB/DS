package com.ds.sort;


public class MergeSort {
    public static void main(String[] args){
        int maxSize=100;
        DArray array = new DArray(maxSize);
        array.insert(64);
        array.insert(21);
        array.insert(33);
        array.insert(70);
        array.insert(12);
        array.insert(85);
        array.insert(44);
        array.insert(3);
        array.insert(99);
        array.insert(0);
        array.insert(108);
        array.insert(36);
        array.display();
        array.mergeSort();
        array.display();
    }
}
class DArray {
    private long []array;
    private int nElems;

    public DArray(int max) {
        array = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }
    public void display() {
        for (int i=0;i<nElems;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace,0,nElems-1);
    }
    public void recMergeSort(long []workSpace,int lower,int upper) {
        if (lower==upper) return;
        else {
            int mid = (lower+upper)>>1;
            recMergeSort(workSpace,lower,mid);
            recMergeSort(workSpace,mid+1,upper);
            merge(workSpace,lower,mid+1,upper);
        }
    }
    public void merge(long []workSpace,int lowPtr,int highPtr,int upper) {
        int j=0;
        int low=lowPtr;
        int mid=highPtr-1;
        int n=upper-low+1;
        while(lowPtr<=mid&&highPtr<=upper)
            if(array[lowPtr]<array[highPtr])
                workSpace[j++]=array[lowPtr++];
            else workSpace[j++]=array[highPtr++];
        while (lowPtr<=mid)
            workSpace[j++]=array[lowPtr++];
        while (highPtr<=upper)
            workSpace[j++]=array[highPtr++];
        for(j=0;j<n;j++) {
            array[low+j]=workSpace[j];
        }
    }

}
