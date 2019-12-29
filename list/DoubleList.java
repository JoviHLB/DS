package com.ds.list;

public class DoubleList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertFirst(22);
        doubleLinkedList.insertFirst(44);
        doubleLinkedList.insertFirst(66);
        doubleLinkedList.insertLast(11);
        doubleLinkedList.insertLast(33);
        doubleLinkedList.insertLast(55);
        doubleLinkedList.displayForward();
        doubleLinkedList.displayBackward();

        doubleLinkedList.deleteFirst();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteKey(11);
        doubleLinkedList.displayForward();

        doubleLinkedList.insertAfter(22,77);
        doubleLinkedList.insertAfter(33,88);
        doubleLinkedList.displayForward();

    }
}
class Link2 {
    public Link2 previous;
    public Link2 next;
    public long dData;
    public Link2(long d) {
        dData=d;
    }
    public void displayLink() {
        System.out.print(dData+" ");
    }
}
class DoubleLinkedList {
    private Link2 first;
    private Link2 last;

    public DoubleLinkedList() {
        first=null;
        last=null;
    }
    public boolean isEmpty() {
        return first==null;
    }
    public void insertFirst(long d) {
        Link2 newLink = new Link2(d);
        if(isEmpty())   last=newLink;
        else first.previous=newLink;
        newLink.next=first;
        first=newLink;
    }
    public void insertLast(long d) {
        Link2 newLink = new Link2(d);
        if(isEmpty())   first=newLink;
        else {
            last.next=newLink;
            newLink.previous=last;
        }
        last=newLink;
    }
    public Link2 deleteFirst() {
        Link2 temp = first;
        if(first.next==null) last=null;
        else first.next.previous=null;
        first = first.next;
        return temp;
    }
    public Link2 deleteLast() {
        Link2 temp =last;
        if(first.next==null) first=null;
        else last.previous.next=null;
        last=last.previous;
        return temp;
    }
    public boolean insertAfter(long key,long d) {
        Link2 current = first;
        while(current.dData!=key) {
            current=current.next;
            if(current==null) return false;
        }
        Link2 newLink = new Link2(d);
        if(current==last) {
            newLink.next=null;
            last=newLink;
        }
        else {
            newLink.next=current.next;
            newLink.next.previous=newLink;
        }
        newLink.previous=current;
        current.next=newLink;
        return true;
    }
    public Link2 deleteKey(long key) {
        Link2 current = first;
        while (current.dData!=key) {
            current=current.next;
            if(current==null) return null;
        }
        if (current==first) first=first.next;
        else current.previous.next=current.next;
        if(current==last) last=last.previous;
        else current.next.previous=current.previous;
        return current;
    }
    public void displayForward() {
        System.out.print("List(first->last):");
        Link2 current = first;
        while (current!=null) {
            current.displayLink();
            current=current.next;
        }
        System.out.println("");
    }
    public void displayBackward() {
        System.out.print("List(last->first):");
        Link2 current = last;
        while (current!=null) {
            current.displayLink();
            current=current.previous;
        }
        System.out.println("");
    }
}
