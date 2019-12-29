package com.ds.stack;

import java.io.*;

public class Brackets {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("Enter string containing delimiter:");
            System.out.flush();
            input=getString();
            if (input.equals("")) break;
            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check();
        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
}
class BracketChecker {
    private String input;
    public BracketChecker(String input) {
        this.input=input;
    }
    public void check() {
        int stackSize = input.length();
        StackX1 stackX1 = new StackX1(stackSize);
		//应该保证length%!=1;若==1，必然错误
        for(int j=0;j<stackSize;j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stackX1.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stackX1.isEmpty()) {
                        char ch1 = stackX1.pop();
                        if(ch=='}'&&ch1!='{'||
                           ch==']'&&ch1!=']'||
                           ch==')'&&ch1!='(')
                            System.out.println("Error:"+ch+"at "+j);
                    }
                    else System.out.println("Error:"+ch+"at "+j);
                    break;
                default:
                    break;
            }
        }
        //分隔符应全部检查完，下面检查：
        if(!stackX1.isEmpty()) System.out.println("Error:missing right delimiter");//右分隔符错误
    }
}
