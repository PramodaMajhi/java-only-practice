package com.structy;

import java.util.Arrays;
import java.util.HashMap;

public class PairSum {
    public int [] pairSum(int[]nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }else {
                hashMap.put(num,i);
            }
        }
        return  new int[]{-1,-1};
    }

    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        int[]nums = {6, 4, 2, 8};
        int target = 12;
        System.out.println(Arrays.toString(pairSum.pairSum(nums, target)));
    }
}
