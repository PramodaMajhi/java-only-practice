package com.gfg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BFSUndirected {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> graph =  buildGraph(adj, V);
        System.out.println("BFS Calling");
        BFS(graph, V, 0);
        System.out.println("DFS Calling");
        DFS(graph,V, 0);
    }

    /**
     * Given an undirected graph and source vertex "src" print BFS
     * from the given source.
     * @param adj
     * @param V
     * @param src
     */
    public static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int src){
        boolean[] visited = new boolean[V];
        Deque<Integer> arrayDeque = new ArrayDeque<Integer>();
        arrayDeque.offer(src); // offer No Exception if there is no space
        visited[src] = true;
        while (!arrayDeque.isEmpty()) {
            int u = arrayDeque.poll();
            System.out.print(u + " -> ");
            for (int v: adj.get(u)) {
                if(!visited[v]){
                    arrayDeque.offer(v);
                    visited[v] = true;
                }
            }
        }

    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int src){
        boolean[] visited = new boolean[V];
        dfsHelper(adj, visited,src);

    }
    private static void dfsHelper(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int u: adj.get(src)) {
            if(!visited[u]){
                dfsHelper(adj, visited, u);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> buildGraph(ArrayList<ArrayList<Integer>> adj, int V){
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0,1);
        addEdge(adj, 0,2);
        addEdge(adj, 1,2);
        addEdge(adj, 1,3);
        addEdge(adj, 2,3);
        addEdge(adj, 2,4);
        addEdge(adj, 3,4);
       printGraph(adj);
       return adj;
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size() ; i++) {
            System.out.print(i+" -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
