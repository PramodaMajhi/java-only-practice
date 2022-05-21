package com.gfg.graph;

import java.util.Arrays;

public class PrimsAlgorithmMST {
    private static int V = 4;
    public static void main(String[] args) {

//        int graph[][] = new int[][]{
//                {0,5,8,0},
//                {5,0,10,0},
//                {8,10,0,20},
//                {0,15,20,0}
//        };
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
       int res =  primMST(graph);
        System.out.println(res);
    }

    private static int minKey (int key[], boolean mstSet[]){

        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if(!mstSet[v] &&  key[v] < min) {
               min = key[v];
               min_index = v;
            }
        }
        return min_index;
    }

    public static int primMST(int graph[][]) {
        // Arrays to store constructed MST
        int[]parent = new int[V];
        // Key values used to pick minimum weight edge in the cut
        int key[] = new int[V];
        // Initialize all keys as infinite
        Arrays.fill(key, Integer.MAX_VALUE);
        // To represent set of vertices included in MST
        boolean mstSet[] = new boolean[V];
        int res = 0;
        // Always include first vertex in MST
        key[0] = 0; // picked first vertex
        parent[0] = -1;  // first node is always root of mst
        // MST will have V vertices
        for (int count = 0; count < V ; count++) {
            int u =  minKey(key, mstSet);
            // add the picked vertex to the MST set
            mstSet[u] = true;

            res = res + key[u];
            // Update key value and present index of the adjacent
            // vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if(!mstSet[v] && graph[u][v]!=0 && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        // print the constructed MST
        printMST(parent, graph);
        return res;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    static void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

}
