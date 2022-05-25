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
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int ans = 0;
        stack.push(-1);
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    public int longestValidParenthesesWithoutSpace(String s) {
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }
            if(c == ')') {
                right++;
            }
            if(left == right){
                ans = Math.max(ans, 2*right);
            } else if(right >= left) {
                left = right = 0;
            }
        }
        left = right = 0; // reset for second iteration
        for (int i = s.length() -1 ; i >=0; i--) {
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }
            if(c == ')') {
                right++;
            }
            if(left == right){
                ans = Math.max(ans, 2*left);
            } else if(left >= right) {
                left = right = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        //String s = ")";
        String s = "(()";
        LongestValidParentheses  longestValidParentheses= new LongestValidParentheses();
        int ans = longestValidParentheses.longestValidParentheses(s);
        int ans1 = longestValidParentheses.longestValidParenthesesWithoutSpace(s);
        System.out.println(ans);
        System.out.println(ans1);

    }
}
