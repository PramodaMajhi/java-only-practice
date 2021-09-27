/**
 * anagrams
Write a function, anagrams, that takes in two strings as arguments. 
The function should return a boolean indicating whether or not the strings are anagrams. 
Anagrams are strings that contain the same characters, but in any order.

test_00:
anagrams('restful', 'fluster'); // -> true
 * @param {*} s1 
 * @param {*} s2 
 * @returns 
 */

const anagrams = (s1, s2) => {
    let str = s1.split('').sort().join('');
    let str2 = s2.split('').sort().join('');
    if (str === str2) return true

    return false;
};

console.log(anagrams('restful', 'fluster')); // -> true)