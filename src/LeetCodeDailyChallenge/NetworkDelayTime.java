package LeetCodeDailyChallenge;

import com.chicago.Jan2;
import javafx.util.Pair;

import java.util.*;
// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    // Adjacency list
    public  Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    public  int networkDelayTimeDFS(int[][] times, int n, int k) {

        // Build the adjacency list
        for (int[] time: times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair<Integer,Integer>(travelTime, dest));
        }
        // Sort the edges connecting to every node
        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a,b) -> a.getKey() - b.getKey());
        }
        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        DFS(signalReceivedAt, k, 0);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <=n ; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }
        // Integer.MAX_VALUE signifies at least one node is reachable
        return answer == Integer.MAX_VALUE ? -1: answer;
    }

    private  void DFS(int[] signalReceivedAt, int currNode, int currTime) {
            // if the current time is greater than or equal to the fastest
        // signal received then no need to iterate over adjacent nodes
        if(currTime >= signalReceivedAt[currNode]) {
            return;
        }
        // Fasted signal time for currNode so far
        signalReceivedAt[currNode] = currTime;
        if(!adj.containsKey(currNode)) {
            return;
        }
        // Broadcast the signal to adjacent nodes
        for(Pair<Integer, Integer> edge: adj.get(currNode)) {
            int travelTime = edge.getKey();
            int neighborNode = edge.getValue();
            // currentTime + time : time when signal reaches neighborNode
            DFS(signalReceivedAt, neighborNode, currTime+travelTime);
        }
    }
    private void BFS(int[] signalReceivedAt, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceNode);

        // Time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!q.isEmpty()) {
            int currNode = q.remove();

            if (!adj.containsKey(currNode)) {
                continue;
            }

            // Broadcast the signal to adjacent nodes
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                int arrivalTime = signalReceivedAt[currNode] + time;
                if (signalReceivedAt[neighborNode] > arrivalTime) {
                    signalReceivedAt[neighborNode] = arrivalTime;
                    q.add(neighborNode);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4; //No. of node
        int k = 2 ; // source
        NetworkDelayTime networkDelayTime  = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTimeDFS(times, n, k);
        System.out.println(result);
    }
}
