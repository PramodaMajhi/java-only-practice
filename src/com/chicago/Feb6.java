package com.chicago;

import java.util.*;

public class Feb6 {
    public static void main(String[] args) {
        int []nums = {1,3,5,3};
        System.out.println(findLonely(nums));
    }

    /*
    2150. Find All Lonely Numbers in the Array
     */
    public static List<Integer> findLonely(int[] nums){
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map   = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }else {
                map.put(num, map.get(num)+1);
            }
        }
        for (int num: map.keySet()) {
            if(map.get(num) == 1 && !map.containsKey(num+1) && !map.containsKey(num-1)){
                ans.add(num);
            }
        }
        return ans;
    }
    /*
     just iterate and update the maximal index that I can reach
     */
    public static boolean canJump(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if(first < i) return false; //  we are not able to reach position i
            first = Math.max(first, i + nums[i]);
        }
        return true;
    }
}
