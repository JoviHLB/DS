package com.ds.stack;

import java.io.*;

//都是个位数的运算
public class suffix {
    public static void main(String[] args) throws IOException {
        String input;
        long output;
        while (true) {
            System.out.println("Enter a suffix: ");
            System.out.flush();
            input = getString();
            if(input.equals("")) break;
            ParsePost parsePost = new ParsePost(input);
            output = parsePost.doParse();
            System.out.println(output);

        }
    }
    public static String getString()throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
}

class ParsePost {
    private String input;
    private StackX stackX;

    public ParsePost(String input) {
        this.input = input;
    }
    public long doParse() {
        stackX = new StackX(20);
        char ch;
        int j;
        long num1,num2,result;
        for (j=0;j<input.length();j++) {
            ch = input.charAt(j);
            if(ch>='0'&&ch<='9') {
                stackX.push(ch-'0');
            }
            else {
                num2 = stackX.pop();
                num1 = stackX.pop();
                switch (ch) {
                    case '+':
                        result = num1+num2;
                        break;
                    case '-':
                        result = num1-num2;
                        break;
                    case '*':
                        result = num1*num2;
                        break;
                    case '/':
                        result = num1/num2;
                        break;
                    default:
                        result = 0;
                }
                stackX.push(result);
            }
        }
        return stackX.pop();
    }
}

