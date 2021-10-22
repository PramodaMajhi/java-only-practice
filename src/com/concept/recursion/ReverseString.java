package com.concept.recursion;

public class ReverseString {
    
    public static String reverseString(String input) {
        if(input.equals("")) {
            return "";
        }
        System.out.println(input.charAt(0));
        System.out.println(input.substring(1));
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void main(String args[]) {
        System.out.println(reverseString("Hello"));
    }
}
