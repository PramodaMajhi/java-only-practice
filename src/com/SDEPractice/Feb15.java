package com.SDEPractice;

public class Feb15 {

    public static void main(String[] args) {
       String s = "abciiidef";
       int k = 3;
        System.out.println(maxVowels(s,k));
    }
    /*
       IDEA: Sliding window of give size
     */

    public static int maxVowels(String s, int k) {
        int max = 0;
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(Character.toString(s.charAt(i))))
                count++;
        }
        max = count;
            for (int j = k; j < s.length(); j++) {
                if(isVowelChar(s.charAt(j)))
                    count++;
                if(isVowelChar(s.charAt(j-k)))
                    count--;
                max = Math.max(max,count);
            }
        return max;
    }

    private static boolean isVowelChar(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
