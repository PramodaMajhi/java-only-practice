package com.SDEPractice;

import java.util.*;

public class Feb17 {
    public static void main(String[] args) {
        int []weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }
    /*
    1011. Capacity To Ship Packages Within D Days
    Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
    Output: 15
    IDEA: Binary search range from max to sum of sub array
     */
    public static int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for (int w: weights) {
            min = Math.max(min, w);
            max+= w;
        }
        int retVal = 0;
        while (min <=max) {
            int mid = (min + max)/2;
            int noOfDaysRequired  = noOfDaysRequired(weights, mid);
            if(noOfDaysRequired > days) {
                // we need more capacity
                min = mid + 1;
            } else {
                // this can be one of are solution
                retVal = mid;
                // Now reduce max
                max = mid -1 ;
            }

        }
        return retVal;
    }
    /*
       Calculate the number of days
     */
    private static int noOfDaysRequired(int [] weights, int capacity) {
        int daysRequired = 1; // 1 <= days <= weights.length <= 5 * 104
        int current = 0; // weight for our current ship
        for (int w: weights) {
            current+=w; // adding weight into current ship
            if(current > capacity) {
                daysRequired++; // days increment
                current = w; //  Does not fit, we need to find next ship
            }
        }
        return daysRequired;
    }

    /*
        1605. Find Valid Matrix Given Row and Column Sums
        Input: rowSum = [3,8], colSum = [4,7]
        Output: [[3,0],[1,7]]
        IDEA: We greedily take min of(row[i], col[j])
        then update the row sum and column sum
    */
    public static int[][] restoreMatrix(int[] row, int[] col) {
        int m  = row.length;
        int n = col.length;
        int [][]matrix = new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
              matrix[i][j] = Math.min(row[i], col[j]);
              row[i]-= matrix[i][j];
              col[j]-= matrix[i][j];
            }
        }
        return matrix;
    }

    /*
    937. Reorder Data in Log Files
    I/): {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     */
    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                // case 1 both logs are letter logs
                if(!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp!=0) return cmp;
                    // logs of same content, compare identifier
                    return split1[0].compareTo(split2[0]);
                }
                // Case 2 one of the log is digit log
                if(!isDigit1 && isDigit2)
                    // letter-log comes before digit logs
                    return -1;
                else if(isDigit1 && !isDigit2) {
                    return 1;
                }else {
                    // Both logs are digit
                    return 0;
                }

            }
        };
        Arrays.sort(logs, stringComparator);
        return logs;
    }
}
