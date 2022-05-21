package com.SDEPractice;

import java.util.ArrayList;
import java.util.List;

public class Mar9 {
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
    public static List<Integer> getRow(int n){
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i<=n; i++) {
            ans.add(getNum(n, i));
        }
        return ans;
    }
    private static int getNum(int row, int col) {
        if(row == 0 || col==0 || row == col) {
            return 1;
        }
        return  getNum(row -1, col -1) + getNum(row-1,col);
    }
}
