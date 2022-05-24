package com.gfg.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/longest-valid-parentheses/
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int ans = 1;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        LongestValidParentheses  longestValidParentheses= new LongestValidParentheses();
        int ans = longestValidParentheses.longestValidParentheses(s);
        System.out.println(ans);

    }
}
