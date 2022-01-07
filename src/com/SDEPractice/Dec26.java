package com.SDEPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dec26 {
    public static void main(String[] args) {
        int [] cost  = {4,3,2,5,6,7,2,5,5};
        //{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        int target =  9;// 516;
      //  System.out.println(addToArrayFormUsingLinkList(num, k));
        System.out.println(largestNumber(cost, target));
    }
/*
Hard: 1449. Form Largest Integer With Digits That Add up to Target
Given an array of integers cost and an integer target, return the maximum integer you can paint under the following rules:

The cost of painting a digit (i + 1) is given by cost[i] (0-indexed).
The total cost used must be equal to target.
The integer does not have 0 digits.
Since the answer may be very large, return it as a string. If there is no way to paint any integer given the condition, return "0".
Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
Output: "7772"
Explanation: The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "977", but "7772" is the largest number.
Digit    cost
  1  ->   4
  2  ->   3
  3  ->   2
  4  ->   5
  5  ->   6
  6  ->   7
  7  ->   2
  8  ->   5
  9  ->   5
 */
    // https://www.youtube.com/watch?v=62D9WIKdTcQ
    String dp[];
    public String largestNumberRec(int[] cost, int target) {

        dp = new String[target+1]; // String dp array to help us memoise
        find(cost, target);

        return dp[target] =="" ? "0" : dp[target];
    }

    public String find(int[] cost, int target) {

        if(target == 0) return "";  // base case if target becomes 0 then it is not possible
        // to form a number

        if(dp[target]!=null) return dp[target];

        String curr = "0"; //base string

        for(int i = 8; i>=0; i--) {
            if(target - cost[i] >= 0) { // we only try to add the digits if its possible to choose from // the cost of array

                String x = find(cost, target-cost[i]);
                // return the maximum number that can be formed
                // using the remaining target once we have chosen the digits
                if(x.equals("0")) continue;  // we could not form a number
                x = String.valueOf((i+1))+x;
                if(curr.equals("0") || x.length() > curr.length())
                    curr = x;
            }
        }
        dp[target] = curr;
        return dp[target];
    }
    public static String largestNumber(int[] cost, int target) {
        int dp [] = new int[target+1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < 9; j++) {
                if(i >= cost[j]) {
                    int costOfj = cost[j];
                    int val  = dp[i-costOfj];
                    dp[i] = Math.max(dp[i],  val+1);
                }
            }
        }
        System.out.println(dp[target]);
        if(dp[target] <0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        int i = 8;
        while (target>0) {
            while (target >= cost[i] && dp[target - cost[i]]+1  == dp[target]) {
                stringBuilder.append(i+1);
                target-=cost[i];
            }
            i--;
        }

        return stringBuilder.toString();
    }
/*
    989. Add to Array-Form of Integer
    The array-form of an integer num is an array representing
    its digits in left to right order.
    Input: num = [1,2,0,0], k = 34
    Output: [1,2,3,4]
    Explanation: 1200 + 34 = 1234
 */
public static List<Integer> addToArrayFormUsingLinkList(int[] num, int k) {

    final LinkedList<Integer> result = new LinkedList<>();
    int len = num.length - 1;

    while(len >= 0 || k != 0){

        if(len >= 0){
            k += num[len--];
        }

        result.addFirst(k % 10);
        k /= 10;
    }
    return result;
}
    public static List<Integer> addToArrayForm(int[] num, int k) {
       StringBuilder sb = new StringBuilder();
        for (int n : num) {
           sb.append(n);
        }
        long val = Long.parseLong(sb.toString()); // Number format exception in case of large number
        val   = val + k;
        String intstr  = Long.toString(val);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i <intstr.length(); i++) {
             Integer numericValue = Character.getNumericValue(intstr.charAt(i));
            System.out.println(numericValue);
            ans.add(numericValue);
        }

        return ans;
    }
}
