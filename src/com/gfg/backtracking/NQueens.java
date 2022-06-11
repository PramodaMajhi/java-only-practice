package com.gfg.backtracking;

import java.util.*;

public class NQueens {
    private int size;
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];
        // set the board to .
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        Set<Integer> cols = new HashSet<Integer>(); // cols
        Set<Integer> posDiag = new HashSet<Integer>(); // r + c
        Set<Integer> negDiag = new HashSet<Integer>(); // r - c
        backtrack(0, cols, posDiag, negDiag, emptyBoard);
        return res;
    }

    private void  backtrack(int row,
                            Set<Integer> cols,
                            Set<Integer> posDig,
                            Set<Integer> negDiag,
                            char[][]boardState){
        // Base case N queens have been placed
        if(row == size)
        {
            res.add(createBoard(boardState));
            return;
        }
        for(int col = 0; col < size; col++){
            int currPosDiagonal = row - col ;
            int currNegDiagonal = row + col;
            // if the queen is not placeable
            if(cols.contains(col)
                    || posDig.contains(currPosDiagonal)
                    || negDiag.contains(currNegDiagonal)){
                continue;
            }
            // add the queen to the board
            cols.add(col);
            posDig.add(currPosDiagonal);
            negDiag.add(currNegDiagonal);
            boardState[row][col] = 'Q';
            // move on to the next row with the updated board state
            backtrack(row+1, cols, posDig, negDiag, boardState);
            // Remove the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            posDig.remove(currPosDiagonal);
            negDiag.remove(currNegDiagonal);
            boardState[row][col] = '.';
        }
    }
    // Making use of a helper function to get the
    // solution in the correct output format
    private  List<String> createBoard(char[][] boardState){
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
           String current_row = new String(boardState[row]);
           board.add(current_row);
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
         //System.out.print(nQueens.solveNQueens(n).size());
        System.out.println(nQueens.solveNQueens(n));
    }
}
