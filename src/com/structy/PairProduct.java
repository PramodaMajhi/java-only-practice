package com.structy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class PairProduct {
    public int[] pairProduct(int[]nums, int target){
        HashMap<Integer,Integer> previous = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target / num;
            if(previous.containsKey(complement)){
                return new int[]{previous.get(complement),i};
            } else{
                previous.put(num, i);
            }
        }
        return new int[]{-1,1};

    }

    public static void main(String[] args) {
        PairProduct product = new PairProduct();
        int[] nums = {3, 2, 5, 4, 1};
        int target = 8;
        System.out.println(Arrays.toString(product.pairProduct(nums, target)));
    }
}
