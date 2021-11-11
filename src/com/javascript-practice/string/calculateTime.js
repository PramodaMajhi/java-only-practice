/**
 * 1165. Single-Row Keyboard
 There is a special keyboard with all keys in a single row.

Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25). Initially, your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

Example 1:

Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4
Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
Total time = 2 + 1 + 1 = 4. 
Example 2:

Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
Output: 73

Time complexity: O(n)O(n). Where nn is the length of word, since we need to traverse the word. An additional constant of O(26) = O(1)O(26)=O(1) is needed to iterate through keyboard.

Space complexity: O(1)O(1). The algorithm requires constant space to store indices for 26 letters.
 */

const calculateTime = (keyboard, word) => {
let key = {}
for(let i=0; i < keyboard.length; i ++) {
    let ch = keyboard.charAt(i);
    key[ch] = i;
}
let count  =  0;
let index = 0
for(let k of word) {
    // add the distance from previous index to the current letter's index to the result
    count+= Math.abs(index - key[k]);
    index = key[k];
}
return count;
}

let keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
// let keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
console.log(calculateTime(keyboard,word));