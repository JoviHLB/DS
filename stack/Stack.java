package com.ds.stack;

public class Stack {
    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);
        //if(!stackX.isFull()) ->insert(item)
        while(!stackX.isEmpty()) {
            long temp=stackX.pop();
            System.out.print(temp+" ");
        }
    }
}
class StackX {
    private int maxSize;
    private long []stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        top=-1;
        stackArray=new long[maxSize];
    }
    public void push(long j) {
        stackArray[++top]=j;
    }
    public long pop() {
        return stackArray[top--];
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
       return (top==-1);
    }
    public boolean isFull() {
        return (top==maxSize-1);
    }
}
