/**
 * Complexity
 * Brute force, regular one
 * O(2^m+n) time
 * O(m+n) space
 * 
 * Memoized
 * O(m*n) time
 * O(m+n) space.
 * 
 * @param {*} m 
 * @param {*} n 
 * @param {*} memo 
 * @returns 
 */

const gridTraveler = (m, n, memo = {}) => {
    const key = m + ',' + n;
    if (key in memo) return memo[key];
    if (m == 1 && n == 1) return 1;
    if (m == 0 || n == 0)
        return 0;
    // m-1 = down to the path
    // n -1 = right to the path
    memo[key] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
    return memo[key];

}
console.log(gridTraveler(2, 3));
console.log(gridTraveler(3, 2));
console.log(gridTraveler(3, 3));
console.log(gridTraveler(18, 18));