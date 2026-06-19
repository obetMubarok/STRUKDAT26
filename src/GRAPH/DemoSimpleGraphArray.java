/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPH;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex{
    String label;
    boolean visited;
    public Vertex(String label) {
        this.label = label;
    }
}

class MyGraph1{
    Vertex[] listVertex;
    int size;
    int[][] matrix;
    int nVertex;//jumlah vertex
    public MyGraph1(int size) {
        this.size = size;
        listVertex = new Vertex[size];
        matrix = new int[size][size];
    }
    public void addVertex(String label){
        listVertex[nVertex++] = new Vertex(label);
    }
    public void addEdge(int start, int end){
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }
    public void resetVisited(){
        for(int i=0;i<nVertex;i++)
            listVertex[i].visited = false;
    }
    public void bfs(int s){
        resetVisited();//set semua vertex visited = false
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            s = queue.remove();
            if(!listVertex[s].visited){
                System.out.print(listVertex[s].label+" ");
                listVertex[s].visited = true;
            }
            //cari neighbor yang belum visited
            for(int i=0;i<nVertex;i++){
                if(matrix[s][i]==1 && !listVertex[i].visited)
                    queue.add(i);
            }
        }
        
    }  
    public void dfs(int s){
        resetVisited();//set semua vertex visited = false
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        
        while(!stack.isEmpty()){
            s = stack.pop();
            if(!listVertex[s].visited){
                System.out.print(listVertex[s].label+" ");
                listVertex[s].visited = true;
            }
            //cari neighbor yang belum visited
            for(int i=nVertex-1;i>=0;i--){
                if(matrix[s][i]==1 && !listVertex[i].visited){
                    stack.add(i);
                }
            }
        }
    }
}
public class DemoSimpleGraphArray {
    public static void main(String[] args) {
        MyGraph1 mg = new MyGraph1(10);
        mg.addVertex("A");//0
        mg.addVertex("B");//1
        mg.addVertex("C");//2
        mg.addVertex("D");//3
        
        mg.addEdge(0, 1);
        mg.addEdge(0, 2);
        mg.addEdge(0, 3);
        mg.addEdge(1, 3);
        mg.addEdge(2, 3);
        
        mg.dfs(1);
        System.out.println("");
        mg.bfs(1);
    }
}
