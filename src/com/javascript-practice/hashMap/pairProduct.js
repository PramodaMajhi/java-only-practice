/**
pair product
Write a function, pairProduct, that takes in an array and a target product as arguments.
The function should return an array containing a pair of indices 
whose elements multiply to the given target. The indices returned must be unique.
Be sure to return the indices, not the elements themselves.
There is guaranteed to be one such pair whose product is the target.

test_00:
    pairProduct([3, 2, 5, 4, 1], 8); // -> [1, 3]

    n = length of array
Time: O(n)
Space: O(n)
 */

const pairProduct = (numbers, targetProduct) => {

    let previousNums = {};
    for (let i = 0; i < numbers.length; i++) {
        const num = numbers[i];
        const complement = targetProduct / num;
        if (complement in previousNums) return [previousNums[complement], i];
        previousNums[num] = i;
    }
}
let val = pairProduct([3, 2, 5, 4, 1], 8);
console.log(val);