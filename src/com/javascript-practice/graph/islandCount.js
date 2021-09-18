/**
 *  * @param {*} grid 
 * Write a function, islandCount, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the number of islands on the grid.
 * An island is a vertically or horizontally connected region of land. 
 * 
 * const grid = [
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'W', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'W'],
  ['L', 'W', 'W', 'L', 'L'],
  ['L', 'L', 'W', 'W', 'W'],
];

islandCount(grid); // -> 3

row = number of rows
col = number of columns
Time: O(rc)
Space: O(rc)
 */

const islandCount = (grid) => {
    const visited = new Set();

    let count = 0;
    for (let r = 0; r < grid.length; r += 1) {
        for (let c = 0; c < grid[0].length; c += 1) {
            if (explore(grid, r, c, visited) === true) {
                count +=1;
            }
        }
    }

    return count;
}

const explore = (grid, row, col, visited) => {
    const rowInbounds = 0 <= row && row < grid.length;
    const colInbounds = 0 <= col && col < grid[0].length;
    if (!rowInbounds || !colInbounds) return false;
    if (grid[row][col] == 'W') return false;

    const pos = row + ',' + col; // you cant store array object[1.2] etc in set if do so set has() return false.
    if (visited.has(pos)) return false;
    visited.add(pos);
    // Depth first search
    explore(grid, row - 1, col, visited); // up
    explore(grid, row + 1, col, visited); // down
    explore(grid, row, col - 1, visited); // left
    explore(grid, row, col + 1, visited); // right

    return true;
}

const grid = [
    ['W', 'L', 'W', 'W', 'W'],
    ['W', 'L', 'W', 'W', 'W'],
    ['W', 'W', 'W', 'L', 'W'],
    ['W', 'W', 'L', 'L', 'W'],
    ['L', 'W', 'W', 'L', 'L'],
    ['L', 'L', 'W', 'W', 'W'],
];

const count = islandCount(grid); // -> 3
console.log(count);