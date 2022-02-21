package com.gfg;

import java.util.Arrays;
import java.util.Comparator;


public class ActivitySelection {
    private static class Activity {
        int start, end;
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity[" +
                    "start=" + start +
                    ", end=" + end +
                    ']';
        }
    }
    public static void main(String[] args) {

    int arr[][] = {{12,25}, {10,20},{20,30}};
    Activity[] activities = new Activity[] {
            new Activity(12,25),
            new Activity(10,20),
            new Activity(20,30)};
        System.out.println(maxActivities(activities));
    }
 // Time: O(nlogn)
    public static int maxActivities(Activity[] activities) {
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a, Activity b) {
                return (a.end - b.end);
            }
        });
        // After sorting
        // [Activity[start=10, end=20], Activity[start=12, end=25],
        // Activity[start=20, end=30]]
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < activities.length; curr++) {
            if(activities[curr].start >= activities[prev].end) {
                res++;
                prev = curr;
            }
        }
        return  res;
    }

    public static int maxActivities(int[][]arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        //after sort
        // [[10, 20], [12,25],[20,30]]
        // sort them using finish time
        System.out.println(Arrays.deepToString(arr));

        int prev = 0;
        int res = 1;
        for (int curr = 1; curr <arr.length ; curr++) {
            if(arr[curr][0] >= arr[prev][1]) {
                res++;
                prev = curr;
            }
        }
        return res;
    }
}

