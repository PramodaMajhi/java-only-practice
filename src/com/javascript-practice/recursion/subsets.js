/*
subsets
Write a function, subsets, that takes in an array as an argument. 
The function should return a 2D array where each subarray represents one of the possible subsets of the array.
The elements within the subsets and the subsets themselves may be returned in any order.
You may assume that the input array contains unique elements.
subsets(['a', 'b']); // ->
// [ 
//   [], 
//   [ 'b' ], 
//   [ 'a' ], 
//   [ 'a', 'b' ] 
// ]
n = length of elements array
Time: ~O(2^n)
Space: ~O(2^n)
*/

const subsets = (arr) => {
    if(arr.length === 0) return [[]];
    const first = arr[0];
    const subsetsWithoutFirst =  subsets(arr.slice(1)) // [[], [b], [c], [b,c]]
    const subsetsWithElement = subsetsWithoutFirst.map((sub) => {
       return  [first, ...sub]; // copy over the subs and adding first element into it.
    })
    // const subsetsWithFirst  = [];
    
    // for(let sub of subsetsWithoutFirst) {
    //     subsetsWithFirst.push([first, ...sub]); // including each element with first element.
    // }
    return[...subsetsWithoutFirst, ... subsetsWithElement];
   
  }
let arr = ['a','b','c'];
const result  = subsets(arr);
  console.log(result);