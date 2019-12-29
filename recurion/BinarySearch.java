package com.ds.recurion;

public class BinarySearch {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray array = new OrdArray(maxSize);
        array.insert(72);
        array.insert(90);
        array.insert(45);
        array.insert(126);
        array.insert(54);
        array.insert(99);
        array.insert(144);
        array.insert(27);
        array.insert(135);
        array.insert(81);
        array.insert(18);
        array.insert(108);
        array.insert(9);
        array.insert(117);
        array.insert(63);
        array.insert(36);
        array.display();
        int searchKey = 27;
        if(array.find(searchKey)!=array.size()) System.out.println("Found"+searchKey);
        else System.out.println("Can't find "+searchKey);
    }
}
class OrdArray {
    private long []a;
    private int nElems;
    public OrdArray(int max) {
        a = new long[max];
        nElems=0;
    }
    public int size() {
        return nElems;
    }
    public int find(long searchKey) {
        return recFind(searchKey,0,nElems-1);
    }
    public int recFind(long searchKey,int lower,int upper) {
        int curIn;
        curIn = (lower+upper)/2;
        if(a[curIn]==searchKey) {
            return curIn;
        }
        else if(lower>upper) {
            return nElems;
        }
        else {
            if(a[curIn]<searchKey) {
                return recFind(searchKey,curIn+1,upper);
            }
            else return recFind(searchKey,lower,curIn-1);
        }
    }
    public void insert(long value) {//插入一个数据
        int i;
        for (i = 0; i < nElems; i++)
            if (a[i] > value)
                break;
        for (int j = nElems; j > i; j--)
            a[j] = a[j - 1];
        a[i] = value;
        nElems++;
    }
    public void display() {
        for (int i=0;i<nElems;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
}
