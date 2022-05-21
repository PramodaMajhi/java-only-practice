package com.SDEPractice;

import java.util.*;

public class NextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length];
        for(int i = nums.length -1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        // Form the answer, answer will be peek element of the stack
        for (int i = nums.length-1; i >=0 ; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
               ans[i] = stack.size() == 0 ? -1 : stack.peek();
                stack.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,4,3};
       // 2,3,4,-1,4
       NextGreaterElementsII nextGreaterElementsII = new NextGreaterElementsII();
       int ans[] = nextGreaterElementsII.nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));

    }
}
