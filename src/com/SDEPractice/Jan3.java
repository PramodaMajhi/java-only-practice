package com.SDEPractice;
import java.util.*;
public class Jan3 {

    public static void main(String[] args) {
        int[][]grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
        // []
    }


/*
807. Max Increase to Keep City Skyline
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
 */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int size  = grid.length;
        int[] rowMaxes = new int[size]; // store max row
        int[] colMaxes = new int[size];  // store max col

        for(int row =0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                System.out.println(rowMaxes[row]);
                System.out.println(grid[row][col]);
                System.out.println( colMaxes[col]);
                rowMaxes[row] = Math.max(rowMaxes[row], grid[row][col]);
                colMaxes[col] = Math.max(colMaxes[col], grid[row][col]);
            }
        }

        int ans = 0;
        for(int row = 0; row< size; row++) {
            for(int col = 0; col <size; col++) {
                ans+=Math.min(rowMaxes[row], colMaxes[col]) - grid[row][col];
            }
        }
        return ans;

    }
/*
1431. Kids With the Greatest Number of Candies
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
 */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans  = new ArrayList<Boolean>(candies.length);
        int max = 0;
        for(int candy : candies) {
            max = Math.max(candy,max);
        }

        for(int candy : candies) {
            ans.add(candy+extraCandies >= max);
        }

        return ans;
    }
}
