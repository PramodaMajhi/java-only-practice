package com.leetcodeContest;

import java.util.*;

public class ContestOn1stJan {

    public static void main(String[] args) {
        //String s = "bbb";
       // System.out.println(checkString(s));
        String [] s = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeam1(s));
    }
    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
//        Arrays.sort(asteroids);
//        for (int asteroid : asteroids) {
//            if ((mass += asteroid) < 2 * asteroid) {
//                return false;
//            }
//        }
//        return true;
        long m = mass;
        Arrays.sort(asteroids);
        for (int ast : asteroids) {
            if (m < ast) {
                return false;
            }
            m += ast;
        }
        return true;
    }
// bank = ["011001","000000","010100","001000"]
    public static int numberOfBeam1(String[] bank) {
        int total = 0;
        int prev = 0;
        int current = 0;


        for(String s : bank) {
            current = 0;
            for (int i = 0; i <s.length() ; i++) {
               char c = s.charAt(i);
               if(c == '1') current++;
            }
            if(current > 0) {
                total = total + (prev * current);
                prev = current;
            }
        }
        return total;
    }
    public static int numberOfBeams(String[] bank) {
        int sum = 0, prev = 0;
        for (String s : bank) {
            sum += s.contains("1") ?
            prev * (prev = s.replace("0", "").length()) : 0;
        }
        return sum;
    }


    public static boolean checkString(String s) {

        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(Character.toLowerCase(s.charAt(i)) == 'a') {
                continue;
            }else {
                for (int j = i; j < s.length(); j++) {
                    if(s.charAt(j) == 'b') {
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
