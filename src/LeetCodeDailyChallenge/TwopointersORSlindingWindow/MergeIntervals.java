package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[]> merged = new LinkedList<int[]>();
        // if the list of merged intervals is empty or if the current
        // interval does not overlap with the previous, simply append
        for (int[] interval: intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            // Otherwise, there is overlap, so we merge the current and previous intervals
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
       int[][]intervals = {{1,3},{2,6},{8,10},{15,18}};
       // Output: [[1,6],[8,10],[15,18]]
        MergeIntervals interval = new MergeIntervals();
        int ans[][] = interval.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
}
