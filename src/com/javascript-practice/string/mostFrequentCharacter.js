/**
 * 
most frequent char
Write a function, mostFrequentChar, that takes in a string as an argument. 
The function should return the most frequent character of the string. 
If there are ties, return the character that appears earlier in the string.

You can assume that the input string is non-empty.
 * @param {*} s 
 */

const mostFrequentCharacter = (s) => {

    let count = {};
    for (let c of s) {
        if (!(c in count)) {
            count[c] = 0;
        }
        count[c]++;
    }
    console.log(count);

    let max = null;

    for (let char of s) {
        if (max === null || count[char] > count[max]) {
           max = char;
        }
    }
    return max;

}

console.log(mostFrequentCharacter('bookepeer')); //  -> e