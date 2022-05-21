package com.SDEPractice;

import java.util.*;

public class Mar10 {
    public static void main(String[] args) {
        int[][]intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int [][] mergeInterval = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(mergeInterval));
    }
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(String op: ops){
            if(op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if(op.equals("C")) {
                stack.pop();
            } else if(op.equals("D")) {
                stack.push(2*stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for(int score :stack) {
            ans+=score;
        }
        return ans;
    }
    /*
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    IDEA: The data structure is important here,
    we created LinkedList<int[]> ans = new LinkedList<int[]>();
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<int[]>();
        int newStart = newInterval[0];
        int newEnd  = newInterval[1];

        // add all intervals starting before newInterval

        int index = 0;
        int n = intervals.length;
        while (index < n && newStart > intervals[index][0]){
            ans.add(intervals[index++]);
        }
        // add new interval

        int[] myInterval = new int[2];

        // if there is no overlap, just add the interval

        if(ans.isEmpty() || ans.getLast()[1] < newStart){
            ans.add(newInterval);
        }
        // if there is an overlap, merge with the last interval
        else {
            myInterval = ans.removeLast();
            myInterval[1]= Math.max(myInterval[1], newEnd);
            ans.add(myInterval);
        }
        // Add next intervals, merge with newInterval if needed

        while(index < n) {
            myInterval = intervals[index++];
            int start = myInterval[0];
            int end  = myInterval[1];

            // If there is no overlap, just add an interval
            if(ans.getLast()[1] < start) {
                ans.add(myInterval);
            }else {
                myInterval = ans.removeLast();
                myInterval[1] = Math.max(myInterval[1], end);
                ans.add(myInterval);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
