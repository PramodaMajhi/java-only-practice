/**
 * 1512. Number of Good Pairs
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */

const numIdenticalPairs = (nums) => {
    const map = {};
    let count = 0;
    for(const num of nums) {
        if(map[num]) {
            count+= map[num];
            map[num]+=1;
        }else {
            map[num] = 1;
        }
    }
    return count;
}

//let nums = [1,2,3,1,1,3];
let  nums = [1,1,1,1] ;
// Output: 4
console.log(numIdenticalPairs(nums));