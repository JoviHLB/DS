package com.ds.list;

public class LinkList {
    private Link first;

    public LinkList() {
        first=null;
    }
    public boolean isEmpty() {
        return (first==null);
    }
    public void insertFirst(int i,double d) {
        Link newLink = new Link(i,d);
        newLink.next = first;
        first = newLink;
    }
    public Link find(int key) {
        Link current = first;
        while (current.iData!=key) {
            if(current.next==null)
                return null;
            else current = current.next;
        }
        return current;
    }
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData!=key) {
            if(current.next==null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current==first) first=first.next;
        else previous.next = current.next;
        return current;
    }
    public Link deleteFirst() {
        Link temp=first;
        first=first.next;
        return temp;
    }
    public void displayList() {
        System.out.print("List (first->last):");
        Link current = first;
        while (current!=null) {
            current.displayLink();
            current=current.next;
        }
        System.out.println("");
    }

}
class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

   public void displayLink() {
        System.out.println("{"+iData+','+dData+"}");
   }

}
//测试
class LinklistApp {
    public static void main(String[] args) {
//        LinkList linkList = new LinkList();
//        linkList.insertFirst(22,2.99);
//        linkList.insertFirst(44,4.99);
//        linkList.insertFirst(66,6.99);
//        linkList.insertFirst(88,8.99);
//        linkList.displayList();
//        while (!linkList.isEmpty()) {
//            Link link = linkList.deleteFirst();
//            System.out.print("Deleted");
//            link.displayLink();
//            System.out.println("");
//        }
//        linkList.displayList();//空
        //上面为简单添加和删除，下面为特定查找和删除
        LinkList linkList = new LinkList();
        linkList.insertFirst(22,2.99);
        linkList.insertFirst(44,4.99);
        linkList.insertFirst(66,6.99);
        linkList.insertFirst(88,8.99);
        linkList.displayList();
        Link link = linkList.find(22);
        link.displayLink();
        linkList.delete(22);//可以接受返回值
        linkList.displayList();
    }
}