package com.ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//infix  to  suffix 中缀表达式转化为后缀表达式
public class ITS {
    public static void main(String[] args) throws IOException {
        String input,output;
        while (true) {
            System.out.println("Enter infix");
            System.out.flush();
            input=getString();
            if (input.equals("")) break;
            InToSuf inToSuf = new InToSuf(input);
            output=inToSuf.doTrans();
            System.out.println("suffix is "+output);
        }
    }
    public static String getString()throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
}
class InToSuf {
    private StackX1 stackX1;
    private String input;
    private String output="";

    public InToSuf(String input) {
        this.input = input;
        stackX1 = new StackX1(input.length());
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stackX1.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;

            }
        }
        while (!stackX1.isEmpty()) {
            output = output + stackX1.pop();
        }
        return output;
    }

    public void gotOper(char opThis, int perc1) {
        while(!stackX1.isEmpty()){
            char opTop=stackX1.pop();
            if(opTop=='('){
                stackX1.push(opTop);
                break;
            }else{
                int prec2;
                if(opTop=='+'||opTop=='-')prec2=1;
                else prec2=2;
                if(prec2<perc1){
                    stackX1.push(opTop);
                    break;
                }else{output=output+opTop;}
            }
        }
        stackX1.push(opThis);
    }

    public void gotParen(char ch) {
        while(!stackX1.isEmpty()){
            char chx=stackX1.pop();
            if(chx=='('){
                break;
            }else{
                output=output+chx;
            }
        }
    }
}
