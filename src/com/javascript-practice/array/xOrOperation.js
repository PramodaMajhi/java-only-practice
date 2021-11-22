/**
 * 1486. XOR Operation in an Array
 * @param {*} n 
 * @param {*} start 
 * @returns 
 * 
Given an integer n and an integer start.
Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
Return the bitwise XOR of all elements of nums.
*/

// Actually we don't need array for this,
const  xorOperation = (n, start) => {
    let ans  = start;
    for(let i = 1; i < n ; i++ ) {
        ans^= start + 2*i;
    }
    return ans;
};
let n = 5, start = 0;
// Output: 8
console.log(xorOperation(n,start));