package com.gfg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class TopologicalSortKahnBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int V = 5;
        createGraph(adj, V);
        printGraph(adj);
        topologicalSort(adj,V);
    }
    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        // create array to store all in-degree of all vertices
        // Initialize all in-degrees to 0
        int [] indegree = new int[V];
        // Traverse adjacency lists to fill indegrees of vertices.
        // This step takes O(V+E)
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> vertices = adj.get(i);
            for (int u : vertices) {
                indegree[u]++;
            }
        }
        System.out.println(Arrays.toString(indegree));
        // add all 0 in-degree vertices into the queue
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < V ; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int u = queue.poll();
             System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if(--indegree[v] == 0)
                    queue.offer(v);
            }
        }
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i <adj.size() ; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adj.get(i).size() ; j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    private static void createGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        // we can calculate in-degree here
        // in-degree[u]++;
    }
}
