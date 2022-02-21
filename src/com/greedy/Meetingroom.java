package com.greedy;

import java.util.Arrays;

public class Meetingroom {
    public static void main(String[] args) {
        int[][] intervals = {{7,10}, {2,4}};//{{13,15}, {1,13}};
       // {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }


    public static int minMeetingRooms(int[][] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        System.out.println(Arrays.deepToString(intervals));
        int res = 1;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] prevInterval = intervals[prev];
            int lastStart =  prevInterval[0];
            int lastEnd = prevInterval[1];
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            if(currentStart > lastEnd) {
                res++;
                prevInterval[1] = currentEnd;
            }
        }
        return res;
    }
}
