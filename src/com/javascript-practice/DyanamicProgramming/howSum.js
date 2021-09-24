/**
 * Write a function `howSum(targetSum, numbers)` thats takes in 
 * targetSum and an array of numbers as arguments.
 * 
 * The function should return an array containing any combination of elements
 * that add up to exactly the targetSum. if there is no combination  
 * thats adds up to the targetSum, then return null.
 * 
 * Complexity:
 * m = target sum
 * n = array length
 * 
 * Brute force
 * -----------
 * O(n^m*m) time exponential
 * O(m) space
 * 
 * Memoized
 * --------
 * O(n*m2) time polynomial
 * O(m^2) space.
 * 
 * 
 */

const howSum = (targetSum, numbers, memo={}) => {
    
    if(targetSum in memo) return memo[targetSum];
    if (targetSum == 0) return [];
    if (targetSum < 0) return null

    for (let num of numbers) {
        const remainder = targetSum - num;
        const remainderResult = howSum(remainder, numbers,memo);
        if (remainderResult !== null) {
            memo[targetSum] =  [...remainderResult,num];
            return memo[targetSum];
        }
    }
    memo[targetSum] = null;
    return null;
}

const test = (n) => {
    if (n < 0) return [];

    const result = test(n - 1);
    return [...result, n];
}

// console.log(test(3));
console.log(howSum(7, [2, 3])); // [3,2,2]
//console.log(howSum(7, [5, 3, 4, 7]));// [4,3]
//console.log(howSum(7, [2, 4])); // null
// console.log(howSum(8, [2, 3, 5])); // [2,2,2,2]
console.log(howSum(300,[7,100])); // null
