/**
 * Write a method to sort an array of strings,
 * so that all the anagrams are next to each other
 * 
 * This algorithm will take O(n log n) time.
 */

const anagramGroup = (arr) => {

    let mapStrArray = arr.map(s => {
        let sortVal = s.split('').sort().join('');
        return {
            orignal: s,
            sorted: sortVal
        }
    })
    //console.log(mapStrArray);
    mapStrArray.sort((a, b) => {
        return a.sorted < b.sorted ? 1 : -1;
    })

    let answer = mapStrArray.map(m => {
        return m.orignal;
    })
    return answer;
}

let s = ['rat', 'car', 'tar'];

/* TEST */

const anagrams = [
    // 'motherinlaw', 
    // 'debit card', 
    // 'dormitory', 
    // 'theearthquakes', 
    // 'astronomer', 
    // 'punishments', 
    // 'schoolmaster', 
    // 'hitlerwoman',
    // 'badcredit',
    // 'dirtyroom',
    // 'thequeershakes',
    // 'moonstarrer',
    // 'ninethumps',
    // 'theclassroom'
    "apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"
];
const anagramsSorted = ["ninethumps", "punishments", "dormitory", "dirtyroom", "astronomer", "moonstarrer", "motherinlaw", "hitlerwoman", "thequeershakes", "schoolmaster", "theclassroom", "badcredit", "theearthquakes", "debit card"];

// console.log(anagramGroup(anagrams));
// groupAnagrams can be sorted
let answer = JSON.stringify(anagramGroup(anagrams))
// let input = JSON.stringify(anagramsSorted);
// if(answer === input) {
//     console.log(true);
// }
console.log(answer);
// console.log(input);
/**
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, 
typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @param {*} strs 
 */
const groupAnagram = (strs) => {
    let cache = {};
    for (let str of strs) {
        let sortedKey = str.split('').join(''); // aet
     ``   (!cache[sortedKey]) ? cache[sortedKey] = [str] : cache[sortedKey].push(str);
    }
    return Object.values(cache);
}
let strs = ["eat","tea","tan","ate","nat","bat"]
const a = groupAnagram(strs);
console.log(a);