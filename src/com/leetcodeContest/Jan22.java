package com.leetcodeContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Jan22 {

    public static void main(String[] args) {
        int []nums = {10,6,5,8};
        System.out.println(findLonely(nums));
    }
    /*
    Input: nums = [10,6,5,8]
    Output: [10,8]
    Explanation:
    - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
    - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
    - 5 is not a lonely number since 6 appears in nums and vice versa.
    Hence, the lonely numbers in nums are [10, 8].
    Note that [8, 10] may also be returned.
     */
    public static List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map  = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length-1; i++) {
            if(!map.containsKey(nums[i])) {
                if(i == 0 && nums[i+1] != nums[i] +1 ) {
                    result.add(nums[i]);
                } else {
                    int prev = nums[i-1] -1;
                    int next = nums[i+1] + 1 ;
                    if( i>0 && nums[i]!= prev && nums[i] != next) {
                        result.add(nums[i]);
                    }
                }

                map.put(nums[i], 1);
            }
        }
        return result;
    }
}
