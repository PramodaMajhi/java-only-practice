package com.gfg.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class AdjacencyListUsingHashMap {
    public static void main(String[] args) {
        HashMap<Integer, TreeSet<Integer>> adj = new HashMap<Integer, TreeSet<Integer>>();
        int V = 5;
        HashMap<Integer, TreeSet<Integer>> result  =  createUndirectedGraph(adj, V);
        printGraph(result);
        searchEdge(result, 2, 1);
        searchEdge(result, 0, 3);
    }

    private static void searchEdge(HashMap<Integer, TreeSet<Integer>> graph, int src , int dest) {
        if(graph.get(src).contains(dest)){
            System.out.println("Edges from "+ src + " to " + " destination " + dest + " found");
        } else {
            System.out.println("Edges from "+ src + " to " + " destination " + dest + " not found");
        }
    }
    private static void printGraph(HashMap<Integer, TreeSet<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            Iterator<Integer> iterator = adj.get(i).iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    public static HashMap<Integer, TreeSet<Integer>> createUndirectedGraph( HashMap<Integer, TreeSet<Integer>> adj, int V){
        for (int i = 0; i < V; i++) {
            adj.put(i, new TreeSet<Integer>());
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
    private static void addEdge( HashMap<Integer, TreeSet<Integer>> adj, int u, int v){
       // add an edge from src to dest into the set
        adj.get(u).add(v);
        // since graph is undirected, add and edge from destination to src
        adj.get(v).add(u);
    }
}
