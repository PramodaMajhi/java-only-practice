package com.FourteenDaysStudyPlan;

public class Day4TwoPointer {
    public static void main(String[] args) {

        String  s = "Let's take LeetCode contest";
        System.out.println( reverseWords(s));
    }
/*
    557. Reverse Words in a String III
    Given a string s, reverse the order of
    characters in each word within a sentence
    while still preserving whitespace and initial word order.

    Example 1:
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
 */

    public static  String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length ; i++) {
            char[] se = arr[i].toCharArray();
            String reversed = reverseHelper(se);
            System.out.println(reversed);
            sb.append(reversed);
            sb.append(" ");

        }

        return sb.toString();
    }

    private static String reverseHelper(char[] c) {
        for (int i = 0; i < c.length/2 ; i++) {
            char temp = c[i];
            c[i] = c[c.length -i -1];
            c[c.length - i -1] = temp;
        }
        return new String(c);
    }
    /*
    Complexities Analysis:
    Time Complexity: O(n) to swap n/2 elements
    Space Complexity: O(1), it's a constant space solution
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i < n/2; i++) {

            char temp = s[i];
            s[i] = s[n-i -1];
            s[n-i-1] = temp;
        }

    }
}
