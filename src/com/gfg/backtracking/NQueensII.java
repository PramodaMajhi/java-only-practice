package com.gfg.backtracking;

import java.util.HashSet;

public class NQueensII {
    private int size;
    public int totalNQueens(int n) {
        size = n;
        char[][]board = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // initial state of the board '.'
            }
        }
        int ans = backtrak(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), board);
        return ans;
    }

    private int backtrak(int row, HashSet<Integer> cols, HashSet<Integer> posDiag,
                         HashSet<Integer> negDiag, char[][]board){
        // Base case when all queens have been placed
        if(row == size)
            return 1;
        int solution = 0;
        for (int col = 0; col < size; col++) {
            int currPosDiagonal = row - col ;
            int currNegDiagonal = row + col;
            if(cols.contains(col)
                    || posDiag.contains(currPosDiagonal)
                    || negDiag.contains(currNegDiagonal)) {
                continue;
            }
            // add the queen to the board
            cols.add(col);
            posDiag.add(currPosDiagonal);
            negDiag.add(currNegDiagonal);
            // move on to the next row with the updated board state
            solution+=backtrak(row+1, cols, posDiag, negDiag, board);
            // Remove the queen from the board since we have already
            // explored all valid paths using above function call
            cols.remove(col);
            posDiag.remove(currPosDiagonal);
            negDiag.remove(currNegDiagonal);
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(1));
    }
}
