package com.SDEPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Feb16 {
    public static void main(String[] args) {
        int [] arr = {0,3,0,3,2};
        System.out.println(maxChunksToSorted(arr));
    }
/*
    768. Max Chunks To Make Sorted II
   IDEA:
    1) Push the bigger value.
    2) Pop the smaller value and restore the big one on top.
 */
    public static int maxChunksToSorted(int[] arr) {
        //  Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0 || stack.peek() <= arr[i]) {
                stack.push(arr[i]);
                continue;
            }
            int max = stack.peek();
            while (stack.size() > 0 && stack.peek() > arr[i]) {
                stack.pop();
            }
            stack.push(max);

        }
        return stack.size();
    }
}
