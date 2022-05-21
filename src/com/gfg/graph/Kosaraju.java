package com.gfg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Kosaraju {
    private int V; // no of vertices
    private ArrayList<ArrayList<Integer>> adj;

    Kosaraju(int v){
        this.V = v;
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private  void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    /*
    Connected Components: For every vertex, all reachable vertices as
    one strongly connected component
    There are three steps
    1) Order the vertices in decreasing order of finish times in DFS
    2) Reverse all the edges
    3) Apply DFS of the reversed graph in the order obtained
    in above step1

    IDEA: Step 1, can be solved using topological sort
          1) create  a stack
          2) for every vertx u do the following
          if(u is not visited)
          DFSRec(u, st)
          while(stack is not empty) pop an item
        DfsRec(u, st)
            a) mark u as visited
            b) for every adjacent v
            if(u is not visited)
            dfsRec(u, stack)
           stack.push(u)
     */
    // Fill vertices in stack according to their finishing
    // times
    public  Deque<Integer>  step1TopologicalSort() {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[V];
        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfsFillOrder(i,visited, stack);
            }
        }
        return stack;
    }
    private void dfsFillOrder(int src, boolean[] visited, Deque<Integer> stack) {
       // Mark the code node as visited
        visited[src] = true;
        // Recur all the vertices adjacent to this vertex
        for(int u : adj.get(src)) {
            if(!visited[u]) {
                dfsFillOrder(u, visited, stack);
            }
        }
        stack.push(src);
    }
    private void dfsUtil(int v, boolean[]visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int u : adj.get(v)) {
            if(!visited[u]) {
                dfsUtil(u, visited);
            }
        }
    }
    public void printStronglyConnectedComp() {
        // step 1
        Deque<Integer> stack =  step1TopologicalSort();
        // step 2
        // Create a reversed graph
        Kosaraju graph = getTranspose();
        boolean[] visited = new boolean[V];
        // Now process all the vertices in order defined by stack
        while (!stack.isEmpty()) {
            int v = stack.pop(); // pop a vertex from stack
            // print strongly connected component of the popped vertex
            if(!visited[v]) {
                graph.dfsUtil(v, visited);
                System.out.println();
            }
        }
    }
    private Kosaraju getTranspose() {
        Kosaraju kosaraju = new Kosaraju(V);
        for (int i = 0; i < V; i++) {
            ArrayList<Integer>  list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                kosaraju.adj.get(j).add(i);
            }
        }
        return kosaraju;
    }

    private void printGraph() {

    }
    public static void main(String[] args) {
        Kosaraju kosaraju = new Kosaraju(5);
        kosaraju.addEdge(1, 0);
        kosaraju.addEdge(0, 2);
        kosaraju.addEdge(2, 1);
        kosaraju.addEdge(0, 3);
        kosaraju.addEdge(3, 4);
        System.out.println("Following are strongly connected components "+
                "in given graph ");
        kosaraju.printStronglyConnectedComp();
    }
}
