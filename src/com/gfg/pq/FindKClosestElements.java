package com.gfg.pq;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public static class MyPair implements Comparable<MyPair> {
        int diff;
        int idx;

         MyPair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }
        @Override
        public String toString() {
            return "MyPair{" +
                    "diff=" + diff +
                    ", idx=" + idx +
                    '}';
        }
        @Override
        public int compareTo(MyPair that) {
         // return  this.diff < that.diff ?   -1 : this.diff >  that.diff ? 1 : 0 ;
           return this.diff == that.diff ? that.diff - this.diff : that.diff - this.diff;
         // return  0;
        }
    }
    public static void getKClosestElement(int arr[],  int x, int k) {
        // Creating Max Heap
        PriorityQueue<MyPair> priorityQueue =
                new PriorityQueue<MyPair>();
        //(a,b) -> a.diff == b.diff ? b.diff - a.diff : b.diff - a.diff
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new MyPair(Math.abs(arr[i] -x), i));
        }
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if(priorityQueue.peek().diff > diff){
                priorityQueue.poll();
                priorityQueue.add(new MyPair(diff, i));
            }
        }
        for (int i = 0; i < k ; i++) {
            System.out.println(arr[priorityQueue.poll().idx]);
        }
    }
    public static void main(String[] args) {
        int arr[] = {30, 40, 32, 33, 36, 37};
        int x = 37;
        int k = 3;
        getKClosestElement(arr, x, k);
    }
}
