package com.gfg.graph;

import java.util.ArrayList;

public class PrintAdjacencyList {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        ArrayList<ArrayList<Integer>> graph = createUnDirectedGraph(V, adj);
        printGraph(graph);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i+"->   ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
/*
    Function to return the adjacency list for each vertex
 */
    public static ArrayList<ArrayList<Integer>> createUnDirectedGraph(int V, ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        return adj;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
