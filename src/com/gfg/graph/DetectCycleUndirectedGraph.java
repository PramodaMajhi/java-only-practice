package com.gfg.graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        createGraph(adj,V);
        printGraph(adj);
        System.out.println(isCyclic(adj, V));
    }

    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean [] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                return dfs(adj, i, visited, -1);
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int parent) {
            visited[src] = true;
        for (int u : adj.get(src)) {
            if(!visited[u]) {
                if(dfs(adj, u, visited, src))
                    return true;
                else if(u!=parent)
                    return true;
            }
        }
        return false;
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size() ; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print( adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    private static void createGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
