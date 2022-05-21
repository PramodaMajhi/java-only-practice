package com.gfg.graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = 4;
        createGraph(adj, V);
        printGraph(adj);
        System.out.println(detectCycle(adj,V));
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean [] visited = new boolean[V];
        boolean [] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                return dfs(adj, visited, recStack, i, -1);
            }
        }

        return false;
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,
                               boolean[]visited, boolean[] recStack,
                               int src, int parent) {
        visited[src] = true;
        recStack[src] = true;
        for (int u : adj.get(src)) {
            if(!visited[u] && dfs(adj, visited, recStack, u, src)) {
                    return true;
            }
            else if(recStack[u])
                return true;
        }
        recStack[src] = false;
        return false;
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i +" ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void createGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

}
