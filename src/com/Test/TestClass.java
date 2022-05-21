package com.Test;

import com.sun.codemodel.internal.JCase;

public class TestClass {
    public static void main(String[] args) {
       String num1 = "11", num2 = "123" ;
        System.out.println(addStrings(num1,num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int remainder = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >=0 ? Character.getNumericValue(num1.charAt(p1)) : 0;
            int x2 = p2 >=0 ? Character.getNumericValue(num2.charAt(p2)) : 0;
            int value  = (x1 + x2 + remainder) % 10;
            remainder= (x1 + x2 + remainder) /10;
            res.append(value);
            p1--;
            p2--;
        }
        if(remainder > 0) {
            res.append(remainder);
        }
        return res.reverse().toString();
    }
}
