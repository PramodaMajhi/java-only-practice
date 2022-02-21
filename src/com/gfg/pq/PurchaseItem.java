package com.gfg.pq;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PurchaseItem {
    // Purchasing items from the cost array with total amount



    public static void main(String[] args) {

     int arr[] = {5, 15, 10, 20, 8, 25, 18};
     int k = 3;
     kthLargestElement(arr, k);
    }

    /**
     * Kth largest element  in an array
     *
     */

    public static void kthLargestElement(int arr[],int k ) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i<k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k+1; i < arr.length ; i++) {
            if(arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }

        }
        System.out.println(priorityQueue);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i <k; i++) {
            ans.add(priorityQueue.poll());
        }
        System.out.println(ans.get(2));

    }

    /**
     * IDEA: To build priority queue, then compare  with sum
     * if it is less than , then we poll from heap and subtract from sum.
     * @param cost
     * @param sum
     * @return
     *
     * O(n) + O(res*logn)
     */
    public static int getNumberOfItem(int cost[], int sum) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int count = 0;
        // Building heap
        for (int item: cost) {
            priorityQueue.add(item);
        }
        while (!priorityQueue.isEmpty() && priorityQueue.peek() < sum) {
            sum = sum - priorityQueue.poll();
            count++;
        }
        return count;
    }
}
