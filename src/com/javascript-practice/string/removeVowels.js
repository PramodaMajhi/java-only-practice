/**
 * Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 * 
Example 1:
Input: s = "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
 */

const removeVowels = (s) => {
    const vowels = "aeiou";
    let news = s.split('');
    const a = s.split('').filter(i => !vowels.includes(i)).join('');
    return a;
}
let s = "leetcodeisacommunityforcoders";
console.log(removeVowels(s));