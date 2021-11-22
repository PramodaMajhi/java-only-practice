/**
 * 14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
*/

const longestCommonPrefix = (strs) => {
    if (strs.length == 0) return "";
    let prefix = strs[0];
    for (let i = 1; i < strs.length; i++) {
        // let myVariable = 
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1);
            if (prefix == '') return "";
        }
    }
    return prefix;
}
/**
This algorithm has a huge advantage when there are too many strings. 
Time Complexity : Since we are iterating through all the characters of all the strings, 
so we can say that the time complexity is O(N M) where, 

N = Number of strings
M = Length of the largest string string 
Auxiliary Space : To store the longest prefix string we are allocating space which is O(M).
 * @param {*} strs 
 * @returns 
 */
// Vertical scanning, characters one by one
const longestCommonPrefix2 = (strs) => {
    if (strs.length == 0) return "";
    let minStr = strs.reduce((prev, cur) => prev.length <= cur.length ? prev : cur);
    // we will go through the characters one by one. which is smallest in string array
    for (let i = 0; i < minStr.length; i++) {

        // Current character (must be same
        // in all strings to be a part of
        // result)
        let current = strs[0].charAt(i);
        for (let j = 1; j < strs.length; j++) {
            if (strs[j].charAt(i) != current) {
                return minStr.substring(0, i);
            }
        }

    }
    return minStr;

}
/**
 Time Complexity: Since we are iterating through all the characters of all the strings, 
 so we can say that the time complexity is O(N M) where, 

N = Number of strings
M = Length of the largest string string
Auxiliary Space: To store the longest prefix string we are allocating 
space which is O(M Log N).

Time complexity : O(S), where SS is the number of all characters in the array, 
S=m⋅n Time complexity is 2⋅T(n/2)+O(m). 
Therefore time complexity is O(S). 
In the best case this algorithm performs O(minLen⋅n) comparisons, 
where minLenminLen is the shortest string of the array
Space complexity :O(m⋅logn)

There is a memory overhead since we store recursive calls in the execution stack. 
There are nlogn recursive calls, each store need mm space to store the result, 
so space complexity is O(m⋅logn)
 */
// Divide and conquer
const longestCommonPrefix3 = (strs) => {
    if (strs == null || strs.length == 0) return "";
    return lcpDC(strs, 0, strs.length - 1);

}
// A Divide and Conquer based function
// to find the longest common prefix. This
// is similar to the merge sort technique
const lcpDC = (strs, low, high) => {

    if (low == high) {
        return strs[low];
    }
    // Same as (low + high)/2, but avoids
    // overflow for large low and high  
    else {
        //let mid = Math.floor(low + high / 2)
        let mid = low + Math.floor((high - low) / 2);
        let leftLCP = lcpDC(strs, low, mid);
        let rightLCP = lcpDC(strs, mid + 1, high);
        return lcp(leftLCP, rightLCP);
    }

}
const lcp = (leftLCP, rightLCP) => {
    // lets find the minimum lcp.so that we can loop through the smallest one
    let min = Math.min(leftLCP.length, rightLCP.length);

    for (let i = 0; i < min; i++) {
        if (leftLCP.charAt(i) !== rightLCP.charAt(i)) {
            return leftLCP.substring(0, i);
        }
    }
    return leftLCP.substring(0, min);
}

// Implement Binary, sorting and Trie

// Binary tree implementation
const longestCommonPrefixUsingBinary = (strs) => {
    if(strs==null || strs.length === 0 ) return "";
    /*  fist find the minimum string out of the array to apply binary search
        We divide the string into two equal parts, we search for left half in all the strings
        if matches, we will keep adding into into the resultant string
        then we search for right half to find additional matching prefix
        If, all the characters is not present in the corresponding indices(low, mid) in all the 
        strings, then we do need to look at the right half , as left half itself is not part of the 
        longest string.
        so, will make the high = mid -1 ;
        finally we can return substring(0, low+high/2) as prefix.

    */
   // step 1 , find the minimum length string
   const min =  (prev, curr) => {
        return prev.length >= curr.length ? curr : prev;
   }
    let minStr = strs.reduce(min);
    // when minimum string is only character then, we need to return the single character
    let low = 1, high = minStr.length;
    // "flow"
   
    while(low <= high) {
        let mid =  Math.floor((low + high)/2);
            if(prefixSearchBinary(strs, mid)) {
            // left half is found , then we are searching for right half
            low = mid + 1 ;
        } else {
            // did not found anything from the left half,
            // so reducing the our substring search
            // go for the left
            high = mid - 1;
        }

    }
   // prefix = minStr.substring(0, Math.floor((low + high/2)));
   //  return prefix;
   let max = Math.floor((low + high)/2);
   return minStr.substring(0, max);
   /**
Complexity Analysis

In the worst case we have n equal strings with length m

Time complexity : O(S⋅logm), where SS is the sum of all characters in all strings.

The algorithm makes  mlogm iterations, for each of them there are S=m⋅n comparisons, 
which gives in total O(S⋅logm) time complexity.

Space complexity : O(1). We only used constant extra space.
    */

}

const prefixSearchBinary = (strs, mid) => {
    let searchStr = strs[0].substring(0, mid);
    for(let i = 1 ; i < strs.length; i ++) {
        if(!strs[i].startsWith(searchStr)) return false
    }
    return true;
}
/**
 * This is sorting approach, the idea is sort the array of strings and 
 * find the common prefix of the first and last string of the sorted array. 
 * let original = ["flower", "flow", "flight"]
 * let afterSort = [flight, flow, flower]
 * 
 * Time Complexity: O(MAX * n * log n ) 
 * where n is the number of strings in the array and 
 * MAX is maximum number of characters in any string. 
 * Please note that comparison of two strings would 
 * take at most O(MAX) time and for sorting n strings, 
 * we would need O(MAX * n * log n ) time
 */

const longestCommonPrefixUsingSort = (strs) => {

    if(strs == null || strs.length == 0) return "";
    if(strs.length == 1) return strs[0];
      let sorted = strs.sort();
      // common prefix of first and last string
      let first  = sorted[0];
      let last  = sorted[strs.length - 1];
      // lets find the minimum string between them.
      let limit  = Math.min(first.length,last.length);
      let prefix = first;
      for(let i = 0 ; i < limit; i ++) {
          if(first.charAt(i)!=  last.charAt(i)) {
            return prefix = first.substring(0, i);
          }
      }
      return prefix;
}
let strs = //["flower","flower","flower","flower"];
["ab", "a"];
 // ["flower", "flow", "flight"]
// let strs = ["dog","racecar","car"];
// Output: "fl"
// ["ab", "a"]
console.log(
    // longestCommonPrefix(strs),
    // longestCommonPrefix2(strs),
    // longestCommonPrefix3(strs),
    // longestCommonPrefixUsingBinary(strs),
    longestCommonPrefixUsingSort(strs)
);