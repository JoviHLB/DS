package com.ds.queue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQX priorityQX = new PriorityQX(5);
        priorityQX.insert(30);
        priorityQX.insert(50);
        priorityQX.insert(10);
        priorityQX.insert(40);
        priorityQX.insert(20);
        while (!priorityQX.isEmpty()) {
            System.out.print(priorityQX.remove()+" ");
        }

    }
}
class PriorityQX {
    private int maxSize;
    private long []queArray;
    private int nItems;

    public PriorityQX(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long[maxSize];
        nItems = 0;
    }
    public void insert(long l) {
        int j=0;
        if(nItems==0) {
            queArray[nItems++]=l;
        }
        else {
            for (j=nItems-1;j>=0;j--) {
                if(l>queArray[j]) {
                    queArray[j+1] = queArray[j];
                }
                else break;
            }
            queArray[j+1]=l;
            nItems++;
        }
    }
    public long remove() {
        return queArray[--nItems];
    }
    public long peekMin() {
        return queArray[nItems-1];
    }
    public boolean isEmpty() {
        return nItems==0;
    }
    public boolean isFull() {
        return nItems==maxSize;
    }
}