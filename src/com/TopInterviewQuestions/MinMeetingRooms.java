package com.TopInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals){
        if(intervals.length == 0)
            return 0; // Base case
        // Initialize mean-heap and add the first meeting's ending time to the heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(
                intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
           }
        );
        // Sort the given meetings by their start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        // add the first meeting, ending time
        priorityQueue.add(intervals[0][1]);
        // iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free,
            // assign that room to this meeting.
            if(intervals[i][0] >= priorityQueue.peek()){
                priorityQueue.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap
            // with updated end time.
            priorityQueue.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        int[][]intervals = {{0,30},{5,10},{15,20}};
        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        System.out.println(minMeetingRooms.minMeetingRooms(intervals));
    }
}
