package com.SDEPractice;

public class Jan30 {

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
    }

        /*
            1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
            IDEA: To find the maximum element in the string.
            that  many numbers deci-binary numbers needed.
         */
        public static  int minPartitions(String n) {
            int max = 0;
            for (int i = 0; i <n.length() ; i++) {
                max = Math.max(max, n.charAt(i) - '0');
            }
            return max;
        }
}
