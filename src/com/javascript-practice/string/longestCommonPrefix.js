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
        let mid = Math.floor(low + high / 2)

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

let strs = ["flower", "flow", "flight"]
// let strs = ["dog","racecar","car"];
// Output: "fl"

console.log(
    // longestCommonPrefix(strs),
    // longestCommonPrefix2(strs),
    longestCommonPrefix3(strs)
);