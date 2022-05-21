package com.gfg.graph;

import java.util.ArrayList;


public class AdjacencyList {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        createUndirectedGraph(adj, V);
        printGraph(adj);

    }
    private static void createUndirectedGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0,1);
        addEdge(adj, 0,2);
        addEdge(adj, 1,2);
        addEdge(adj, 1,3);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i+"-> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
