package com.ds.list;

public class LinkStack {
    private Linklist linklist;
    public LinkStack() {
        linklist = new Linklist();
    }
    public void push(long d) {
        linklist.insertFirst(d);
    }
    public long pop() {
        return linklist.deleteFirst();
    }
    public boolean idEmpty() {
        return linklist.isEmpty();
    }
    public void displayStack() {
        System.out.print("Stack(top->bottom):");
        linklist.displayList();
    }


}
class Linklist {
    private Link1 first;

    public Linklist() {
        first=null;
    }
    public boolean isEmpty() {
        return (first==null);
    }
    public void insertFirst(long d) {
        Link1 newLink = new Link1(d);
        newLink.next = first;
        first = newLink;
    }
    public long deleteFirst() {
        Link1 temp=first;
        first=first.next;
        return temp.dData;
    }
    public void displayList() {
        System.out.print("List (first->last):");
        Link1 current = first;
        while (current!=null) {
            current.display();
            current=current.next;
        }
        System.out.println("");
    }
}
class StackApp {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.push(20);
        linkStack.push(40);
        linkStack.displayStack();
        linkStack.push(60);
        linkStack.push(80);
        linkStack.displayStack();
        linkStack.pop();
        linkStack.pop();
        linkStack.displayStack();
    }
}
