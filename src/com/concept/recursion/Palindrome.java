package com.concept.recursion;

public class Palindrome {
    public static boolean isPalindrome(String input) {
        if(input.length() == 0 || input.length() == 1) {
            return true;
       }
       if(input.charAt(0) == input.charAt(input.length() -1 )) {
           return isPalindrome(input.substring(1, input.length() - 1));
       }
       // additional base-case to handle non palindromes.
       return false;
    }

    public static void main(String args[]) {
        System.out.println(isPalindrome("16461"));
    }
}
