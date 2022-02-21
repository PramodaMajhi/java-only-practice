package com.SDEPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Jan20 {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {

        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                if(st.size() > 0) {
                    sb.append('(');
                }
                st.push(s.charAt(i));
            }else {
                st.pop();
                if(st.size() > 0) {
                    sb.append(')');
                }
            }
        }
        return   sb.toString();
    }
}
