package com.ds.list;

public class LinkQueue {
    private FirstLastList firstLastList;

    public LinkQueue() {
        firstLastList = new FirstLastList();
    }
    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }
    public void insert(long d) {
        firstLastList.insertLast(d);
    }
    public long remove() {
        return firstLastList.deleteFirst();
    }
    public void displayQueue() {
        System.out.println("Queue(front->rear):");
        firstLastList.displayList();
    }
}
class QueueApp {
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(20);
        linkQueue.insert(40);
        linkQueue.displayQueue();
        linkQueue.insert(60);
        linkQueue.insert(80);
        linkQueue.displayQueue();
        linkQueue.remove();
        linkQueue.remove();
        linkQueue.displayQueue();
    }
}
