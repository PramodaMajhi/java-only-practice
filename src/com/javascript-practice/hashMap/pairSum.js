/**
 * pair sum
Write a function, pairSum, that takes in an array and a target sum as arguments. The function should return an array containing a pair of indices whose elements sum to the given target. The indices returned must be unique.

Be sure to return the indices, not the elements themselves.

There is guaranteed to be one such pair that sums to the target.

test_00:
pairSum([3, 2, 5, 4, 1], 8); // -> [0, 2]

n = length of array
Time: O(n)
Space: O(n)
 */

const pairSum = (numbers, targetSum) => {
    let previousNums = {}
    for (let index = 0; index < numbers.length; index++) {
        const num = numbers[index];
        const complement = targetSum - num;
        if (complement in previousNums) return [previousNums[complement], index];
        previousNums[num] = index;

    }

}

console.log(pairSum([3, 2, 5, 4, 1], 8));