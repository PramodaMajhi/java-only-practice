/**
 * Write a function `canSum(target, numbers)` that takes in a targetsum and 
 * an array of numbers as arguments.
 * The function should return boolean indicating whether or not it
 * possible  to generate the tagetsum using numbers from the array.
 * 
 * You may use an element of the array as many times as needed.
 * You may assume that all input numbers are non negative.
 * 
 * m = target sum
 * n = length of the array
 * Brute force
 * (n^m) time
 * O(m) space
 * 
 * memoized:
 * O(m*n) time
 * O(m) space
 * 
 */

const canSum = (targetSum, numers, memo = {}) => {

    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return true;
    if (targetSum <= 0) return false;

    for (let num of numers) {
        const remainder = targetSum - num;
        if (canSum(remainder, numers, memo) === true) {
            memo[targetSum] = true;
            return true;
        }

    }
    memo[targetSum] = false;
    return false;
}

console.log(canSum(7, [2,3])); // true
console.log(canSum(7, [5,3, 4, 7])); // true
console.log(canSum(7, [2, 4])); // false
console.log(canSum(7, [2,3,5])); // true
console.log(canSum(300, [7, 14])); // true