package com.gfg.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelString {
    private static String[]vowel = {"a","e","i","o","u"};
    public static List<String> countVowelStrings(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, res, 0, new StringBuilder());
        return  res;
    }

    private static void helper(int n, List<String> res, int index, StringBuilder builder) {
        if(n == builder.length()) {
            res.add(builder.toString());
            return;
        }
        for(int i = index; i < 5; i++) {
            // add the string to string builder
            builder.append(vowel[i]);
            helper(n, res,i, builder );
            builder.deleteCharAt(builder.length()-1);
        }
    }
//Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
       // "aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"
      //   aa,  ae,  ai,  ao,  au,  ea,  ee,  ei,  eo,  eu,  ia,  ie,  ii,  io,iu, oa, oe, oi, oo, ou, ua, ue, ui, uo, uu
    }
}
