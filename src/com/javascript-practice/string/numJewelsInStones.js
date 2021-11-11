/**
 * 771. Jewels and Stones
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. 
 * You want to know how many of the stones you have are also jewels.Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * 
Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0

Time Complexity: O(J\text{.length} + S\text{.length})O(J.length+S.length). The O(J\text{.length})O(J.length) part comes from creating J. The O(S\text{.length})O(S.length) part comes from searching S.

Space Complexity: O(1).since they are 26 * 2 characters at most and HashSet.add() will ignore duplicates.
*/
/**
 * 
 * Hint: For each stone,check if it is a jewel
 */
const numJewelsInStones = (jewels, stones) => {
    let count = 0
    for(let i = 0 ; i < stones.length; i ++) {
        if(jewels.includes(stones.charAt(i))) count++;
    }
    return count;
}
const numJewelsInStones2 = (jewels, stones) => {
    let count = 0
    let mySet  = new Set(jewels);
    for(let i = 0 ; i < stones.length; i ++) {
        if(mySet.has(stones.charAt(i))) count++;
    }
    return count;
}
const numJewelsInStones3 = (jewels, stones) => {
   const newArr = stones.split('').filter(char => jewels.indexOf(char) !== -1);
   return newArr.length;
}

let jewels = "aA", stones = "aAAbbbb"
console.log(numJewelsInStones(jewels,stones),
numJewelsInStones2(jewels,stones),
numJewelsInStones3(jewels,stones)
);