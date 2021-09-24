/**
 * Write a function `bestSum(targetSum, numbers)` that takes in targetSum
 * and array of numbers as arguments.
 * 
 * The function should return an array containing the shortest combination 
 * of numbers that add up exactly the targetsum.
 * 
 * if there is a tie for the shortest combination, you may return any of the shortest.  
 *  m = target sum
 *  n = numbers.length
 * 
 * Brute force
 * Time : O(n^m*m)
 * Space : O(m^2)
 * 
 * Memoized
 * Time O(n*m^2)
 * Space: O(m2) space
 * polynomial complexity 
 * 
 */

const bestSum = (targetSum, numbers, memo={}) => {

    if(targetSum in memo) return memo[targetSum];
    if (targetSum == 0) return [];
    if (targetSum < 0) return null;
    let shortestCombination = null;
    for (let num of numbers) {
        const remainder = targetSum - num;
        let remainderCombination = bestSum(remainder, numbers, memo);

        if (remainderCombination != null) {
            let combination = [...remainderCombination, num];
            if (shortestCombination == null || combination.length < shortestCombination.length) {
                shortestCombination = combination;
            }
        }
    }
    memo[targetSum] = shortestCombination;
    return shortestCombination;
}

console.log(bestSum(7, [2, 3])); // [3,2,2]
console.log(bestSum(7, [5, 3, 4, 7]));// [4,3]
console.log(bestSum(7, [2, 4])); // null
console.log(bestSum(8, [2, 3, 5])); // [2,2,2,2]
console.log(bestSum(100,[1,2,5,25])); // null