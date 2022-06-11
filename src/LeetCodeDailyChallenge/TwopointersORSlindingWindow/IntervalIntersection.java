package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    // Lists are sorted, use two pointers
    // i and j
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<int[]>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            // To check A[i] intersects B[i]
            // lo - the start point of the intersection
            // high = the end point of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1],B[j][1]);
            if(lo <= hi){
                ans.add(new int[]{ lo, hi});
            }
            // Remove the interval with the smallest end point
            if(A[i][1] < B[j][1]){
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][]A = {{0,2},{5,10},{13,23},{24,25}};
        int[][]B = {{1,5},{8,12},{15,24},{25,26}};
        // Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        IntervalIntersection interval = new IntervalIntersection();
        int[][]ans = interval.intervalIntersection(A, B);
        System.out.println(Arrays.deepToString(ans));
    }
}
