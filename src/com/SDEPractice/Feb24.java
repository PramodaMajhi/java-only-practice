package com.SDEPractice;

import javafx.beans.binding.StringBinding;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Feb24 {

    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
    /*
    1190. Reverse Substrings Between Each Pair of Parentheses
    Input: s = "(abcd)"
    Output: "dcba"
     */
    public static String reverseParentheses(String s) {
        Deque<StringBuilder> deque = new ArrayDeque<>();
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch  = s.charAt(i);
            if(ch == '(') {
               deque.push(sb);
               sb = new StringBuilder();
            } else if(ch == ')') {
                String str = sb.reverse().toString();
                sb = deque.pop();
                sb.append(str);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
/*
IDEA; If K = 1 , that always true for jashua
covert into binary then take the firs bit and append at last then convert
into decimal for winner.
In case K always varies.
IDEA: Create a list and put starting from 1 to n (inclusive)
then start removing start from 0, (start + k - 1) % arrayList.size();
after removing and assign start  = start%list size();
finally return list.get(0)


 */
    public static int findTheWinner(int n, int k) {
//        String binaryString  = Integer.toBinaryString(n);
//        StringBuilder stringBuilder  = new StringBuilder(binaryString);
//        stringBuilder.deleteCharAt(0);
//
//        String firstDigit =  Character.toString(binaryString.charAt(0));
//        stringBuilder.append(firstDigit);
//        return Integer.parseInt(stringBuilder.toString(),2);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i<= n; i++) {
            arrayList.add(i);
        }
        int start  = 0;
        while (arrayList.size() > 1) {
            int ind =  (start + k - 1) % arrayList.size();
            arrayList.remove(ind);
            start = (ind)%arrayList.size();
        }
        return arrayList.get(0);
    }

    // Recursion
    public static int findWinner(int n , int k) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= n ; i++) {
            arrayList.add(i);
        }
        return josephus(n, k, 0, arrayList);
    }

    private static  int josephus(int n , int k, int start, ArrayList<Integer> arrayList) {

        if(n > 1) {
            int curr = (start + k -1) % n;
            arrayList.remove(curr);
            josephus(n-1, k, curr, arrayList);
        }
        return arrayList.get(0);
    }
}
