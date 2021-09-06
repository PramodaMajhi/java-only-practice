/**
 * Write a function, minimumIsland, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the size of 
 * the smallest island. An island is a vertically or horizontally connected region of land.
 * You may assume that the grid contains at least one island.
 * 
 * const grid = [
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'W', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'W'],
  ['L', 'W', 'W', 'L', 'L'],
  ['L', 'L', 'W', 'W', 'W'],
];
    minimumIsland(grid); // -> 2

r = number of rows
c = number of columns
Time: O(rc)
Space: O(rc)
 */

const minimumIsland = (grid) => {
    const visited = new Set();
    let minSize = Infinity;
    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            const size = exploreSize(grid, row, col, visited);
            if (size > 0 && size < minSize) {
                minSize = size;
            }
        }

    }
    return minSize;

};

const exploreSize = (grid, row, col, visited) => {
    const rowInbounds = 0 <= row && row < grid.length;
    const colInbounds = 0 <= col && col < grid[0].length;

    if (!rowInbounds || !colInbounds) return 0;

    if (grid[row][col] == 'W') return 0;
    const pos = row + ',' + col;
    if (visited.has(pos)) return 0;
    visited.add(pos);

    let size = 1;
    size += exploreSize(grid, row - 1, col, visited); // up 
    size += exploreSize(grid, row + 1, col, visited); // down
    size += exploreSize(grid, row, col - 1, visited); // left
    size += exploreSize(grid, row, col + 1, visited); // right

    return size;

};

const grid = [
    ['L', 'W', 'W', 'L', 'W'],
    ['L', 'W', 'W', 'L', 'L'],
    ['W', 'L', 'W', 'L', 'W'],
    ['W', 'W', 'W', 'W', 'W'],
    ['W', 'W', 'L', 'L', 'L'],
];

const minIland = minimumIsland(grid); // -> 2
console.log(minIland);

