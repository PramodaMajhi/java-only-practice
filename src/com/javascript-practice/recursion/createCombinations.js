/*
create combinations
Write a function, createCombinations, that takes in an array and a length as arguments. 
The function should return a 2D array representing all of the combinations of the specifized length.
The items within the combinations and the combinations themselves may be returned in any order.
You may assume that the input array contains unique elements and 1 <= k <= items.length.
createCombinations(["a", "b", "c"], 2); // ->
// [
//   [ 'a', 'b' ],
//   [ 'a', 'c' ],
//   [ 'b', 'c' ]
// ]
n = length of items
k = target length
Time: ~O(n choose k)
Space: ~O(n choose k)
Note: "n Choose k" refers to the binomial coefficient.
nCk = n!/ k!(n-k)!
*/

const createCombinations = (items, k) => {
    
    if(k == 0) return [[]];
    if(k > items.length) return [];

    const first = items[0];
    const combinations = createCombinations(items.slice(1), k -1); // which is 2d array
    let result = []
    for (const comb of combinations) {
        result.push([first, ...comb]);
    }

    const combWithFirst = createCombinations(items.slice(1), k);
    return [...result, ...combWithFirst ]

  }
 const output =  createCombinations(["a", "b", "c"], 2); // ->
  // [
  //   [ 'a', 'b' ],
  //   [ 'a', 'c' ],
  //   [ 'b', 'c' ]
  // ]
  console.log(output);