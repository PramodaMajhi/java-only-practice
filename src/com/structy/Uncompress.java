package com.structy;

import sun.jvm.hotspot.ui.tree.CStringTreeNodeAdapter;

public class Uncompress {
    public String uncompress(String s){
        StringBuilder  stringBuilder = new StringBuilder();
        int j = 0;
        int number = 0;
       while (j < s.length()) {
            char c  = s.charAt(j);
            if(Character.isDigit(c)){
                number = number * 10 + c -'0';
                j++;
            }else {
                j++;
                for (int k = 0; k < number; k++) {
                    stringBuilder.append(c);
                }
                number = 0;
            }
        }
       return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "127y";
        Uncompress uncompress = new Uncompress();
        System.out.println(uncompress.uncompress(s));

    }
    // nnneeeeeeeeeeeezz
    // nnneeeeeeeeeeeezz

}
