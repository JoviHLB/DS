package com.ds.graph;
//最小生成树
public class DFSApp {

}
class StackX {
    private final int SIZE = 20;
    private int []st;
    private int top;
    public StackX() {
        st = new int[SIZE];
        top = -1;
    }
    public void push(int j) {
       st[++top]=j;
    }
    public long pop() {
        return st[top--];
    }
    public long peek() {
        return st[top];
    }
    public boolean isEmpty() {
        return (top==-1);
    }
    public boolean isFull() {
        return (top==SIZE-1);
    }
}
class Vertex {
    public char label;
    public boolean wasVisited;
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }

}
class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX stackX;
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        for(int j=0; j<MAX_VERTS; j++)
            for (int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        stackX = new StackX();
    }
    public void addVertex(char lab) {

    }
}