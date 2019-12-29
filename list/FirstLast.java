package com.ds.list;
//双端链表
public class FirstLast {
    public static void main(String[] args) {
        FirstLastList firstLastList = new FirstLastList();
        firstLastList.insertFirst(22);
        firstLastList.insertFirst(44);
        firstLastList.insertFirst(66);
        firstLastList.insertLast(11);
        firstLastList.insertLast(33);
        firstLastList.insertLast(55);
        firstLastList.displayList();
        firstLastList.deleteFirst();
        firstLastList.deleteFirst();
        firstLastList.displayList();
    }

}
class Link1 {
    public long dData;
    public Link1 next;

    public Link1(long dData) {
        this.dData = dData;
    }

    public void display() {
        System.out.print(dData+" ");
    }
}
class FirstLastList {
    private Link1 first;
    private Link1 last;

    public FirstLastList() {
        first=null;
        last=null;
    }
    public boolean isEmpty() {
        return first==null;
    }
    public void insertFirst(long d) {
        Link1 newLink = new Link1(d);
        if(isEmpty()) last=newLink;
        newLink.next=first;
        first=newLink;
    }
    public void insertLast(long d) {
        Link1 newLink = new Link1(d);
        if(isEmpty()) first=newLink;
        else last.next=newLink;
        last=newLink;
    }
    public long deleteFirst() {
        long d = first.dData;
        if(first.next==null) last=null;
        first = first.next;
        return d;
    }
    public void displayList() {
        System.out.print("List(first-->last):");
        Link1 current = first;
        while (current!=null) {
            current.display();
            current=current.next;
        }
        System.out.println("");
    }
}