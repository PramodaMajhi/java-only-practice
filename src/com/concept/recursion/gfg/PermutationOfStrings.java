package com.concept.recursion.gfg;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfStrings {
    public static void main(String[] args) {
        System.out.println(permute("ABC", 0, new ArrayList<String>()));
    }
/*
Print all permutation of a strings
input: ABC
output: ABC, ACB, BAC, BCA, CBA, CAB
 */
    public static List<String> permute(String str, int index, List<String> res) {
        if(str.length() - 1 == index) {
           // System.out.println(str);
            res.add(str);
            return res;
        }
            for (int i = index; i < str.length(); i++) {
                str = swap(str,index, i);
                permute(str, index+1, res);
                str = swap(str,index ,i);
            }
       return res;
    }
    private static String swap(String s, int i , int j) {
        char temp;
        char[] carr = s.toCharArray();
         temp = carr[i];
         carr[i] = carr[j];
         carr[j] = temp;
         return new String(carr).toString();
    }
}
