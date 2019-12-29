package com.ds.sort;

public class ObjectSort {
    public static void main(String[] args) {
        int maxSize=100;
        ArrayObj arrayObj = new ArrayObj(maxSize);
        arrayObj.insert("Evans","Party",24);
        arrayObj.insert("Smith","Doc",59);
        arrayObj.insert("Smith","Lorraine",37);
        arrayObj.insert("Yee","Tom",43);
        arrayObj.insert("Hash","Sato",21);
        arrayObj.insert("Stimson","Horry",29);
        arrayObj.insert("Vela","Jose",72);
        arrayObj.insert("Vang","Minh",22);
        arrayObj.insert("Creswell","Lucinda",18);
        System.out.println("Before:");
        arrayObj.display();
        System.out.println("After:");
        arrayObj.objectSort();
        arrayObj.display();
    }
}
class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
    public void display() {
        System.out.println("lastName="+lastName+",firstName="+firstName+",age="+age);
    }

    public String getLastName() {
        return lastName;
    }
}
class ArrayObj {
    private Person []person;
    private int nElems;
    public ArrayObj(int max) {
        person=new Person[max];
        nElems=0;
    }
    public void insert(String last,String first,int age) {
        person[nElems++]=new Person(last,first,age);
    }
    public void display() {
        for (int j=0;j<nElems;j++) {
            person[j].display();
            System.out.println("");
        }
    }
    public void objectSort() {
        int out,in;
        Person temp;
        for(out=1;out<nElems;out++) {
            in=out;
            temp=person[out];
            while(in>0&&person[in-1].getLastName().compareTo(temp.getLastName())>0) {
                person[in]=person[in-1];
                in--;
            }
            person[in]=temp;
        }
    }
}
