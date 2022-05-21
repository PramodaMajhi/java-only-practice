package com.gfg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ShortestPathUnWeighted {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        createGraph(adj,V);
        printGraph(adj);
        shortestUnWeighted(V, 0, adj);
    }
/*
    BSF always traverse shortest closer manner
 */
    public static void shortestUnWeighted(int V, int src, ArrayList<ArrayList<Integer>> adj){
        int []dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;
        boolean[] visited = new boolean[V];
        // create a queue
        Deque<Integer> arrayDeque = new ArrayDeque<Integer>();
        arrayDeque.offer(src);
        visited[src] = true;
        while (!arrayDeque.isEmpty()){
            int u = arrayDeque.poll();
            System.out.println(u + "--> ");
            for (int v : adj.get(u)){
                if(!visited[v]){
                    arrayDeque.offer(v);
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i+ "  ");
            for (int j = 0; j <adj.get(i).size() ; j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void createGraph(ArrayList<ArrayList<Integer>> adj, int V){
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
