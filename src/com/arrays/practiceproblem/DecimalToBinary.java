package com.arrays.practiceproblem;

import java.util.Arrays;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(7));
    }

    public static String convertDecimalToBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n!=0) {
            int remainder = n%2;
            stringBuilder.append(remainder);
            n = n/2;
        }
        return stringBuilder.toString();
    }
}
