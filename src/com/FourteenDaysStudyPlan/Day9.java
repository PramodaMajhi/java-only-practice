package com.FourteenDaysStudyPlan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

enum Day {Monday, Tuesday, Wednesday, Thursday};

public class Day9 {

    static class Pair {
        int x ;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
       int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
//https://www.youtube.com/watch?v=DU3kgZNtdwk
    public static  int orangesRotting(int[][] grid) {
            int total = 0; int rotten = 0, time = 0;
            Queue<Pair> queue = new LinkedList<>();
            for (int r = 0; r <grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if(grid[r][c] == 1 || grid[r][c] == 2) {
                        total++;
                    }
                    if (grid[r][c] == 2) {
                        queue.offer(new Pair(r,c));
                    }
                }
            }

            if(total == 0) return 0;

            while (!queue.isEmpty()){
                int size  = queue.size();
                rotten+=size;
                if(rotten == total) return time;
                time++;

                for (int i = 0; i <size; i++) {
                    Pair p = queue.peek();

                    if(p.x+1 < grid.length && grid[p.x+1][p.y] == 1) {
                        grid[p.x+1][p.y] = 2;
                        queue.offer(new Pair(p.x+1,p.y));
                    }
                    if(p.x-1 >= 0 && grid[p.x-1][p.y] == 1) {
                        grid[p.x-1][p.y] = 2;
                        queue.offer(new Pair(p.x-1,p.y));
                    }
                    if(p.y+1 < grid[0].length && grid[p.x][p.y+1] == 1) {
                        grid[p.x][p.y+1] = 2;
                        queue.offer(new Pair(p.x,p.y+1));
                    }
                    if(p.y-1 >= 0 && grid[p.x][p.y-1] == 1) {
                        grid[p.x][p.y-1] = 2;
                        queue.offer(new Pair(p.x,p.y-1));
                    }
                    queue.poll();
                }
            }

            return  -1;

    }
}
