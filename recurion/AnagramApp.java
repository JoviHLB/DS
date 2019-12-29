package com.ds.recurion;

import java.io.*;

public class AnagramApp {
    static int size;
    static int count;
    static char []arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a word:");
        String input = getString();
        size=input.length();
        count=0;
        for (int i=0;i<size;i++)
            arrChar[i] = input.charAt(i);
        doAnagram(size);
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
    public static void doAnagram(int newSize) {
        if (newSize==1) return;
        for (int i=0;i<newSize;i++) {
            doAnagram(newSize-1);
            if(newSize==2) display();
            rotate(newSize);//调用轮转方法
        }
    }
    public static void display() {
        if(count<99) System.out.print(" ");
        if(count<9) System.out.print("  ");
        System.out.print(++count+" ");
        for (int i=0;i<size;i++) System.out.print(arrChar[i]);
        System.out.print("   ");
        System.out.flush();
        if(count%6==0) System.out.println("");
    }
    public static void rotate(int newSize) {
        int i;
        int position = size-newSize;
        char temp=arrChar[position];
        for (i=position+1;i<size;i++) arrChar[i-1]=arrChar[i];
        arrChar[i-1]=temp;
    }
}
