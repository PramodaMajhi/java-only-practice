package com.SDEPractice;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/4sum
    https://leetcode.com/problems/friends-of-appropriate-ages
    https://leetcode.com/problems/check-if-array-is-sorted-and-rotated
 */
public class Jan6 {

    public static void main(String[] args) {
      int[]  nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }
/*
    1752. Check if Array Is Sorted and Rotated
    Input: nums = [3,4,5,1,2]
    Output: true
    Explanation: [1,2,3,4,5] is the original sorted array.
    You can rotate the array by x = 3 positions to begin on
    the element of value 3: [3,4,5,1,2].
 */
    public static boolean check(int[] nums) {
        int k = 0;
        int len = nums.length;
        for (int i = 0; i <len; i++) {
            /*int a = nums[i];
            int b = nums[(i+1)%len];
            /*
            Note: An array A rotated by x positions results in an array B
            of the same length such that A[i] == B[(i+x) % A.length],
            where % is the modulo operation.
             */
//            if (nums[i] > nums[(i + 1) % len]) {
//                k++;
//            }
            int a = nums[i];
            int b;
            if(i == nums.length-1) {
                b = nums[0];
            } else b = nums[i+1];
            if(a > b) {
                k++;
            }
        }
        if(k > 1) return false;

        return true;
    }

    /*
        825. Friends Of Appropriate Ages
        age[y] <= 0.5 * age[x] + 7
        age[y] > age[x]
        age[y] > 100 && age[x] < 100

        Input: ages = [16,17,18]
        Output: 2
        Explanation: Friend requests are made 17 -> 16, 18 -> 17.
     */
    public static int numFriendRequests(int[] ages) {
            if(ages.length ==2 && ages[0] == ages[1]) return ages.length;
            int numOfFrnd = 0;
            for (int i = 0; i < ages.length -1; i++) {
                for (int j = i+1; j < ages.length; j++) {
                    if(canMakeRequest(ages[i], ages[j])) {
                        numOfFrnd++;
                    }
                    if(canMakeRequest(ages[j], ages[i])) {
                        numOfFrnd++;
                    }
                }
            }
            return numOfFrnd;
    }

    private static boolean canMakeRequest(int from, int to) {
        return to<=from && to>0.5*from+7;
    }

    public int numFriendRequests1(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages)
            count.put(age, count.getOrDefault(age, 0) + 1);
        int res = 0;
        for (Integer a : count.keySet())
            for (Integer b : count.keySet())
                if (request(a, b))
                    res += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }

}
