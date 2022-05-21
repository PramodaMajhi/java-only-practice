package com.SDEPractice;

import java.util.Arrays;

public class MinStepsTwoStringAnagram {
    public static int minSteps(String s, String t) {
        if(s.equals(t))
            return 0;

        int charCount[] = new int[26];
        // iterate through the first string and update count
        // Iterate through the second string and update the char count
        // if character is found then decrease
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] ++;
            charCount[t.charAt(i) - 'a'] --;
        }


        int count = 0;
        for (int i : charCount) {
            if(i > 0){
                count+= i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "bab", t = "aba";
        System.out.println(minSteps(s, t));

    }
}
