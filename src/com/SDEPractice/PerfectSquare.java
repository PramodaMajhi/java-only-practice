package com.SDEPractice;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num>=0) {
            int sqrt = (int)Math.sqrt(num);
            return ( (sqrt * sqrt) == num);

        }
        return false;
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        boolean ans = perfectSquare.isPerfectSquare(16);
        System.out.println(ans);
    }
}
