package com.gfg.pq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MergeKSortedArray {
    private static class Triplet implements Comparable<Triplet>{
        int val;
        int arrPos;
        int arrValPos;
        Triplet(int val, int arrPos, int arrValPos) {
            this.val = val;
            this.arrPos = arrPos;
            this.arrValPos = arrValPos;
        }

       @Override
        public int compareTo(Triplet t) {
            if(this.val <= t.val) return -1;
            else return 1;
        }
    }

    public static List<Integer> mergeArr(List<List<Integer>> arr) {

        PriorityQueue<Triplet> priorityQueue = new PriorityQueue<Triplet>();
        List<Integer> res = new ArrayList<Integer>();
        // 2D matrix
        for (int i = 0; i <arr.size() ; i++) {
            // add each element from the each array
            // Value, position of array and position of value in array
            Triplet triplet = new Triplet(arr.get(i).get(0),i,0);
            priorityQueue.add(triplet);
        }
        while (!priorityQueue.isEmpty()){
            Triplet curr = priorityQueue.poll(); // getting the first min element from heap
            res.add(curr.val);
            int arrPos = curr.arrPos;
            int arrValPos = curr.arrValPos;
            // Check if the element exist from the remove array
            if(arrValPos + 1 < arr.get(arrPos).size()){
                priorityQueue.add(new Triplet(arr.get(arrPos).get(arrValPos+1),arrPos, arrValPos+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer arr[][] = {{5,10},{4,9},{6}};
        List<List<Integer>> list = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());

         System.out.println(mergeArr(list));
    }
}
