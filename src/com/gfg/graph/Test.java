package com.gfg.graph;

public class Test {
    public static void main(String[] args) {
        System.out.println(solve(1,2,3));
//        int n = 4;
//        while (n > 0){
//            n++;
//            n-=2;
//        }

    }

    public static int solve (int a , int b, int c) {
        int ans = 0;

        if(a == 0 && b == 0 && c == 0){
            return 1;
        }
        if(a > 0) {
            ans+= solve(a-1, b, c);
        }
        if(b > 0) {
            ans+= solve(a, b-1, c);
        }
        if(c > 0) {
            ans+= solve(a, b, c-1);
        }
       return ans;
    }
}
