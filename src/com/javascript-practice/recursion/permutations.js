/*
permutations
Write a function, permutations, that takes in an array an argument. 
The function should return a 2D array where each subarray represents one of the possible permutations of the array.
The subarrays may be returned in any order.
You may assume that the input array contains unique elements.
permutations(['red', 'blue']); // ->
// [ 
//   [ 'red', 'blue' ], 
//   [ 'blue', 'red' ] 
// ]

n = length of items array
Time: ~O(n!)
Space: ~O(n!)
*/
const permutations = (arr) => {
    
    if(arr.length == 0) return [[]];
    const firstElement = arr[0];
    const perms = permutations(arr.slice(1)); // [[],[red], [blue]]
    const fullPermutaions = [];
    for (let perm of perms) {
        for (let i = 0; i <= perm.length; i++) {
            const ele =     [...perm.slice(0,i), firstElement, ...perm.slice(i)];
            fullPermutaions.push(ele);
        }
    }
    return fullPermutaions;
  }
  const permutations2 = (arr, set = [], answer=[]) => {
    if(!arr.length) 
     answer.push([...set]);

     for (let i = 0; i < arr.length; i++) {
         let newArr = arr.filter((item, index) => index!==i);
         set.push(arr[i]);
         permutations2(newArr, set, answer);
         set.pop();
     }
    return answer;
  }

  var permute = function(nums) {
    if(!nums || nums.length < 1)
        return [];
    
    const LEN = nums.length;
    let ans = [[nums[0]]], idx = 1;
    while(idx < LEN) {
        let val = nums[idx], newAns = [];
        for(let arr of ans) {
            for(let i = 0; i <= arr.length; i++) {
                let ar = arr.slice();
                ar.splice(i, 0, val);
                newAns.push(ar);
            }                        
        }
        
        idx++;
        ans = newAns;
        //console.log(ans);
    }
    
    return ans;
};

var permute = function (nums) {
    const results = [];
    backtracking(0, nums, results);
    return results;
};


var backtracking = function (first, nums, results) {
    if (first === nums.length) {
        results.push(nums.concat());
        return;
    }
    for (let i = first; i < nums.length; i++) {
        swap(nums, i, first);
        backtracking(first + 1, nums, results);
        swap(nums, i, first);
    }
}

var swap = function (nums, firstIndex, secondIndex) {
    const temp = nums[firstIndex];
    nums[firstIndex] = nums[secondIndex];
    nums[secondIndex] = temp;
}

let arr = ['a', 'b']

  console.log(permutations2(arr))
  