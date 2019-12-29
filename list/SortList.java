package com.ds.list;

public class SortList {
    private Link1 first;

    public SortList() {
        first = null;
    }
    public boolean isEmpty() {
        return first==null;
    }
    public void insert(long d) {
        Link1 newLink = new Link1(d);
        Link1 previous = null;
        Link1 current = first;
        while(current!=null&&d>current.dData) {
            previous=current;
            current = current.next;
        }
        if(previous==null) first=newLink;
        else previous.next=newLink;
        newLink.next=current;
    }
    public Link1 remove() {
        Link1 temp = first;
        first = first.next;
        return temp;
    }
    public void displayList() {
        System.out.print("List(first->last):");
        Link1 current =first;
        while (current!=null) {
            current.display();
            current=current.next;
        }
        System.out.println("");
    }
}
class SortApp {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        sortList.insert(20);
        sortList.insert(40);
        sortList.displayList();
        sortList.insert(10);
        sortList.insert(30);
        sortList.insert(50);
        sortList.displayList();
        sortList.remove();
        sortList.remove();
        sortList.displayList();
    }
}
