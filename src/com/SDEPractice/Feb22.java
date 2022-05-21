package com.SDEPractice;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Feb22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    public static int candyTwoArray(int[] ratings) {
        int [] left2Right = new int[ratings.length];
        int [] right2Left = new int[ratings.length];
        Arrays.fill(left2Right,1);
        Arrays.fill(right2Left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                left2Right[i] = left2Right[i-1] + 1;
            }
        }

        for (int i = ratings.length -2 ; i >=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                right2Left[i] = right2Left[i+1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum+= Math.max(left2Right[i], right2Left[i]);
        }
        return sum;
    }
    /*
        135. Candy
    */
    public static int candy(int[] ratings) {
        int []candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean  hasChanged = true;
        while(hasChanged) {
            hasChanged = false;
            for (int i = 0; i < ratings.length; i++) {
                if(i != ratings.length -1 && ratings[i] > ratings[i+1]
                        && candies[i] <= candies[i+1]) {
                    candies[i] = candies[i+1] + 1;
                    hasChanged = true;
                }
                if(i > 0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]){
                    candies[i] = candies[i-1] + 1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for (int candy: candies) {
            sum+=candy;
        }
        return sum;
    }
/*
    22. Generate Parentheses
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    IDEA:
    Backtrack, only add when we know it will remain a valid sequence.
    We can keep track of opening and closing brackets we have placed so far
    We can start an opening bracket if we still have one (of n) left to place
    We can start a closing bracket if it would not exceed the number of opening
    brackets
 */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if(n <= 0) return ans;
         dfs(ans, new StringBuilder(), 0, 0, n);
         return ans;
    }
    private static void dfs(List<String> result, StringBuilder builder, int leftP, int rightP, int n) {

        if(builder.length() == n*2){
            result.add(builder.toString());
        }
        if(leftP< n) {
            builder.append("(");
            dfs(result,builder, leftP+1, rightP, n);
            builder.deleteCharAt(builder.length() -1);
        }
        if(rightP < leftP ){
            builder.append(")");
            dfs(result,builder, leftP, rightP +1 , n);
            builder.deleteCharAt(builder.length() -1);
        }

    }
}
