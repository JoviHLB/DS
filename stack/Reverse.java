package com.ds.stack;

import java.io.*;

public class Reverse {
    public static void main(String[] args) throws IOException {
        String input,output;
        /*简单明了
        input="huangLiBing";
        output=new Reverser(input).doRev();
        System.out.println(output);
        */
        //以下为控制台输入形式Java代码
        while (true) {
            System.out.println("Enter a string:");
            System.out.flush();
            input=getString();
            if (input.equals("")) break;
            Reverser reverser = new Reverser(input);
            output=reverser.doRev();
            System.out.println("Reversed:"+output);
        }
    }
    public static String getString()throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
}
class StackX1 {
    private int maxSize;
    private char []stackArray;
    private int top;

    public StackX1(int maxSize) {
        this.maxSize = maxSize;
        top=-1;
        stackArray=new char[maxSize];
    }
    public void push(char j) {
        stackArray[++top]=j;
    }
    public char pop() {
        return stackArray[top--];
    }
    public char peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top==-1);
    }
    public boolean isFull() {
        return (top==maxSize-1);
    }
}
class Reverser {
    private String input;
    private String output;
    public Reverser(String input) {
        this.input=input;
    }
    public String doRev() {
        int stackSize=input.length();
        StackX1 stackX1 = new StackX1(stackSize);
        for(int j=0;j<stackSize;j++) {
            char ch=input.charAt(j);
            stackX1.push(ch);
        }
        output="";
        while(!stackX1.isEmpty()) {
            char ch=stackX1.pop();
            output+=ch;
        }
        return output;
    }
}
