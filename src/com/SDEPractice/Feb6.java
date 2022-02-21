package com.SDEPractice;

import java.util.Stack;

public class Feb6 {
    public static void main(String[] args) {
        String num = "10200"; int k = 1;
        System.out.println(removeKdigits(num, k));

    }
    public static String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        Stack<Character> stack = new Stack<Character>();

        for(char digit: num.toCharArray()) {

            while (k>0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        // corner case 1111 or 123
        while (k>0 && stack.size()  > 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        // remove all leading zero

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();

    }
}
