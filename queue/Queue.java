package com.ds.queue;

public class Queue {
    public static void main(String[] args) {
        QueueX queueX = new QueueX(5);
        queueX.insert(10);
        queueX.insert(20);
        queueX.insert(30);
        queueX.insert(40);
        queueX.remove();
        queueX.remove();
        queueX.remove();
        queueX.insert(50);
        queueX.insert(60);
        queueX.insert(70);
        queueX.insert(80);
        while(!queueX.isEmpty()) {
            long n = queueX.remove();
            System.out.print(n);
            System.out.println(" ");
        }
        int m=70;
        System.out.println(m+"元素在位置"+queueX.findElems(m));
    }
}
class QueueX {
    private int maxSize;
    private long []queArray;
    private int front;
    private int rear;
    private int nElems;
    public QueueX(int maxSize) {
        this.maxSize=maxSize;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
        nElems=0;
    }
    public void insert(long l) {
        if(rear==maxSize-1) rear=-1;//循环队列，队尾到顶了 从头来(如果队头前有空余位置)
        queArray[++rear]=l;
        nElems++;
    }
    public long remove() {
        if(front==maxSize) front=0;
        long temp=queArray[front++];
        nElems--;
        return temp;
    }
    public long peekFront() {
        return queArray[front];
    }
    public boolean isEmpty() {
        return nElems==0;
    }
    public boolean isFull() {
        return nElems==maxSize;
    }
    public int size() {
        return nElems;
    }
    public int findElems(long l) {
        for(int i=0;i<maxSize;i++) {
            if(queArray[i]==l) return i;
        }
        return -1;
    }
}
//没有nElems属性的队列
/*
class QueueX {
    private int maxSize;
    private long []queArray;
    private int front;
    private int rear;
    public QueueX(int maxSize) {
        this.maxSize=maxSize;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
        nElems=0;
    }
    public void insert(long l) {
        if(rear==maxSize-1) rear=-1;//循环队列，队尾到顶了 从头来(如果队头前有空余位置)
        queArray[++rear]=l;
    }
    public long remove() {
        if(front==maxSize) front=0;
        long temp=queArray[front++];
        return temp;
    }
    public long peekFront() {
        return queArray[front];
    }
    public boolean isEmpty() {
        return rear+1==front||(front+maxSize-1==rear);
    }
    public boolean isFul l() {
        return rear+2==front||(front+maxSize-2==rear);
    }
    public int size() {
        if(rear>=front)
            return rear*front+1;
        else
            return (maxSize*front)+(rear+1);
    }
}
*/