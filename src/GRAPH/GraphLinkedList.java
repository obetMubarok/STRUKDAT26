package GRAPH;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

class MyGraph{
    int numV;
    LinkedList<Integer>[] adj;
    
    Queue<Integer> queue = new LinkedList<>();
    public MyGraph(int numV) {
        this.numV = numV;
        adj = new LinkedList[numV];
        for(int i=0;i<numV;i++)
            adj[i] = new LinkedList<>();
    }
    public void addEdge(int start, int end){
        adj[start].add(end);
        adj[end].add(start);
    }
    public void BFS(int s) {
        boolean visited[] = new boolean[numV];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.remove();

            if (!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }
            //cari neighbor yang belum visited
            ListIterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n])
                    queue.add(n);
            }
        }
    }
    
    public void DFS(int s){
        boolean visited[] = new boolean[numV];
        Stack<Integer> stack = new Stack<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.remove();
            if (!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            //cari neighbor yang belum visited
            ListIterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n])
                    queue.add(n);
            }
        }
    }
}
public class GraphLinkedList {
    public static void main(String[] args) {
        MyGraph mg = new MyGraph(4);
        mg.addEdge(0, 1);
        mg.addEdge(0, 2);
        mg.addEdge(1, 2);
        mg.addEdge(1, 3);
        
        mg.BFS(0);
        System.out.println("");
        mg.DFS(0);
    }
}
