package com.concept.recursion;

public class KthGrammer {

    public static void main(String[] args) {
        System.out.println(kthGrammar(2,2));
    }
    /*
        779. K-th Symbol in Grammar
        Input: n = 2, k = 2
        Output: 1
        Explanation:
        row 1: 0
        row 2: 01

        IDEA:
        Inorder to find the value of the kth position is 0 or 1, if we can determine
        the parent of K i.e is previous row. by getting ceiling value of k divided by 2 in the n-1 row,
        can be recursively until n ==1
        also we need to determine kth parent is 1 or 0. our intuition is if k is 0dd first position
        and if k is even its second position.
        Note : take care of 1 0 and 0 1 scenario
          0
        0  1
       0 1 1 0

     */

    public static int kthGrammar(int n, int k) {
        if(n==1) return 0;

        boolean iskOdd = k%2 == 1;
        int parent  = kthGrammar(n-1, (k/2 + k%2));
        if (parent == 1) {
            return iskOdd ? 1 : 0; // 1 0
        }else {
            return iskOdd ? 0 : 1; // 0 1
        }
    }
}
