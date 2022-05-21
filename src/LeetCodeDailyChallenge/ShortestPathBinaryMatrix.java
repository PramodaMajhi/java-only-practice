package LeetCodeDailyChallenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShortestPathBinaryMatrix {
    private static final int[][] directions =
            {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0}, {1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Firstly, we need to check that, start and target cells are open
        if(grid[0][0]!=0 || grid[m -1][n - 1]!=0){
            return -1;
        }
        // Set up the BFS
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int currentDistance = 1; // self
        // carry out the BFS
        while (!queue.isEmpty()) {
          // process all nodes at current distance from top left cell
            int nodeAtCurrentDistance = queue.size();
            for (int i = 0; i <nodeAtCurrentDistance; i++) {
                // poll from the queue
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                // if start and target match then we reach
                if(row == m -1 && col == n-1) {
                    return currentDistance;
                }
                for (int[] neighbour: getNeighbours(row, col, grid)) {
                    int neighbourRow = neighbour[0];
                    int neighbourCol = neighbour[1];
                    if (visited[neighbourRow][neighbourCol]) {
                        continue;
                    }
                    visited[neighbourRow][neighbourCol] = true;
                    queue.add(new int[]{neighbourRow, neighbourCol});
                }
            }
            // We'll now be processing all nodes at current_distance + 1
            currentDistance++;
        }
        // Target was not reachable
        return -1 ;
    }

    private List<int[]> getNeighbours(int row, int col, int[][]grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row +  directions[i][0];
            int newCol = col + directions[i][1];
            if(newRow < 0 || newCol < 0 || newRow >=grid.length
            || newCol >= grid[0].length
            || grid[newRow][newCol]!=0){
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

    public static void main(String[] args) {
        int[][]grid = {{0,1},{1,0}};
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new
                ShortestPathBinaryMatrix();
        int ans = shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}
