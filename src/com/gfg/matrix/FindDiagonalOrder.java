package com.gfg.matrix;

import java.util.*;

public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0) return new int[0];
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                if(!dict.containsKey(sum)){
                    dict.put(sum, new ArrayList<>());
                }
                dict.get(sum).add(mat[i][j]);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : dict.entrySet()) {
            List<Integer> temp_list = new ArrayList<Integer>();
            if(entry.getKey()%2 == 0) {
                temp_list  = entry.getValue();
                Collections.reverse(temp_list);
            } else {
                temp_list = entry.getValue();
            }
            for (int i = 0; i < temp_list.size(); i++) {
                res[index++] = temp_list.get(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][]mat = {{1,2,3},{4,5,6},{7,8,9}};
       // Output: [1,2,4,7,5,3,6,8,9]
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[]ans = findDiagonalOrder.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(ans));

    }
}
