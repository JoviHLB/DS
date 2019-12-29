package com.ds.list;

import java.io.*;

class IteratorApp {
    public static void main(String[] args) throws IOException {
        LinkList1 linkList1 = new LinkList1();
        ListIterator listIterator = new ListIterator(linkList1);
        long value;
        listIterator.insertAfter(20);
        listIterator.insertAfter(40);
        listIterator.insertAfter(80);
        listIterator.insertBefore(60);
        while (true) {
            System.out.println("Enter first letter of show,reset,");
            System.out.println("next,get,before,after,delete:");
            System.out.flush();
            char choice=getchar();
            switch (choice) {
                case 's':
                    if(!linkList1.isEmpty()) linkList1.displayList();
                    else System.out.println("List is empty");
                    break;
                case 'r':
                    listIterator.reset();
                    break;
                case 'n':
                    if(!linkList1.isEmpty()&&!listIterator.atEnd()) listIterator.nextLink();
                    else System.out.println("Cant't go to next link");
                    break;
                case 'g':
                    if(!linkList1.isEmpty()) {
                        value=listIterator.getCurrent().dData;
                        System.out.println("Returned"+value);
                    }
                    else System.out.println("List is empty");
                    break;
                case 'b':
                    System.out.println("Enter value to insert");
                    System.out.flush();
                    value=getInt();
                    listIterator.insertBefore(value);
                    break;
                case 'a':
                    System.out.println("Enter value to insert");
                    System.out.flush();
                    value=getInt();
                    listIterator.insertAfter(value);
                    break;
                case 'd':
                    if(!linkList1.isEmpty()) {
                        value=listIterator.deleteCurrent();
                        System.out.println("Delete"+value);
                    }
                    else System.out.println("Can't delete");
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
    }
    public static char getchar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s =getString();
        return Integer.parseInt(s);
    }
}
public class ListIterator {
    private Link1 previous;
    private Link1 current;//当作成游标，指向节点位置(操作完)
    private LinkList1 ourList;
    public ListIterator(LinkList1 linkList1) {
        ourList=linkList1;
        reset();
    }
    public void reset() {
        current=ourList.getFirst();
        previous=null;
    }
    public boolean atEnd() {
        return current.next==null;
    }
    public void nextLink() {
        previous=current;
        current=current.next;
    }
    public Link1 getCurrent() {
        return current;
    }
    public void insertAfter(long d) {
        Link1 newLink = new Link1(d);
        if(ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current=newLink;
        }
        else {
            newLink.next=current.next;
            current.next=newLink;
            nextLink();
        }
    }
    public void insertBefore(long d) {
        Link1 newLink = new Link1(d);
        if(previous==null) {
            newLink.next=ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        }
        else {
            newLink.next=previous.next;
            previous.next=newLink;
            current=newLink;
        }
    }
    public long deleteCurrent() {
        long value = current.dData;
        if(previous==null) {
            ourList.setFirst(current.next);
            reset();
        }
        else {
            previous.next=current.next;
            if(atEnd()) reset();
            else current=current.next;
        }
        return value;
    }
}
class LinkList1 {
    Link1 first;

    public LinkList1() {
        first=null;
    }
    public Link1 getFirst() {
        return first;
    }
    public void setFirst(Link1 first) {
        this.first=first;
    }
    public boolean isEmpty() {
        return first==null;
    }
    public ListIterator getIterator() {
        return new ListIterator(this);
    }
    public void displayList() {
        Link1 current=first;
        while (current!=null) {
            current.display();
            current=current.next;
        }
        System.out.println("");
    }

}

