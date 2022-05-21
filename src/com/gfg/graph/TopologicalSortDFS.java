package com.gfg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TopologicalSortDFS {
    public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = 5;
        createGraph(adj,V);
        printGraph(adj);
        topologicalSort(adj,V);
    }

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[]visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++) {
            if(!visited[i])
                dfs(adj, visited, stack, i);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[]visited,
                Deque<Integer> stack, int src){
        visited[src] = true;
       for(int u : adj.get(src)){
           if(!visited[u]) {
               dfs(adj, visited, stack, u);
           }
       }
       stack.push(new Integer(src));
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    private static void createGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0,1 );
        addEdge(adj, 1,3 );
        addEdge(adj, 2,3 );
        addEdge(adj, 3,4 );
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
