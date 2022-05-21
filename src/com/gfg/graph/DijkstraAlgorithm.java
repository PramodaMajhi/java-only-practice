package com.gfg.graph;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int graph[][] = {
                {0,5,10,0},
                {5,0,3,20},
                {10,3,0,2},
                {0,20,2,0}
        };
        // Output:{0,5,8,10}
        int[] dist = dijkstra(graph, 0);
        System.out.println(Arrays.toString(dist));
        printSolution(dist, graph.length);
    }
    private static void printSolution(int[] dist, int V) {
        System.out.println("Vertex \t\t Distance from source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
    public static int[] dijkstra(int graph[][], int src) {
        int V =  graph.length;
        // The output array. dist[i] will hold
        // the shortest distance from src to i
        int dist[] = new int[V];
        Arrays.fill(dist,  Integer.MAX_VALUE);
        // fin[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        boolean[] fin = new boolean[V];
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
        // Find the shortest path for all vertices
        for (int count = 0; count < V -1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = -1;
            for (int i = 0; i < V; i++) {
                if(!fin[i] && (u == -1 || dist[i] < dist[u])){
                    u = i;
                }
            }
            // Mark the picked vertex as processed
            fin[u] = true;
            // Update dist[v] only if is not in sptSet, there is an
            // edge from u to v, and total weight of path from src to
            // v through u is smaller than current value of dist[v]
            for (int v = 0; v <V ; v++) {
                if(!fin[v] && graph[u][v]!=0)
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
            }
        }
        return dist;
    }

}
