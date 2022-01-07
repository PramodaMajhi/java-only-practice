package com.SDEPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         public int f(int x, int y);
}

public class Dec23 {

    public static void main(String[] args) {
       int []nums = {1,2,3,4};
        //System.out.println(Arrays.toString(runningSum(nums)));
        System.out.println(Arrays.toString(runningSumRec(nums,0)));
    }
    /*
        Analysis:
        1. we don't know all the functions 1<=function<=9
        2. Use linear search, x is 1 to 1000 and y 1000 to 1;
        3. if f(x,y) > z, y = y-1
        4. if f(x,y) < z, x = x+1
        5. if f(x,y) = z, record[x,y]
        6. return all f(x,y) answer
        Complexity: Space O(x+y), Time: O(1) excluding return list.
     */
    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int x = 1, y = 100;
        while (x < 1001 && y >0){
            int val = customFunction.f(x,y);
            if(val < z) {
                x++;
            }else if(val > z) {
                y--;
            }
            else {
                ans.add(Arrays.asList(x,y));
                x++;
                y--;
            }
        }
        return ans;
    }
    /*
        1480. Running Sum of 1d Array
        Given an array nums.
        We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
        Return the running sum of nums.
        Input: nums = [1,2,3,4]
        Output: [1,3,6,10]
        Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     */
// Time: O(n) Where n is the length of the array
    // Space: O(1) no additional space.
    public static  int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i!=0)
                nums[i] = nums[i] + nums[i-1];
            else nums[i] = nums[i];
        }
        return nums;
    }
    public static  int[] runningSumRec(int[] nums, int index) {
        if(nums.length == index) return  nums;

        if(index!=0){
            nums[index]+=nums[index-1];
        }

        return runningSumRec(nums, index+1);
    }

}
