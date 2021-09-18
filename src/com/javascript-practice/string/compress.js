/**
 * write a function, uncompress, that takes in a string as an argument.
 * The input string will be formatted into multiple groups according to the following
 * The function should return an uncompressed version of the string where each char of a group
 * is repeated 'number' times consecutively .
 * uncompress("2c3a1t"); // -> 'ccaaat'
 * @param {*} s 
 */

const compress = (s) => {

    let words = {};
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        // console.log(c);
        if (c in words) {
            let value = words[c];
            words[c] = value + 1;

        } else {
            words[c] = 1;
        }
    }
    let str = ""
    for (const key in words) {
        let val = words[key];
        if (val == 1) {
            val = "";
        }
        str = str + val + key;
    }
    return str;
}
const a = compress("ppoppppp"); //compress('ppoppppp'); // -> '2po5p'
// console.log(a);
                //      j
 // compressVersion2('ccaaatsss')
 //                   i
 //                   012345678  
const compressVersion2 = (s) => {
    let i = 0;
    let j = 0;
    let result = [];

    while (j <= s.length) {
        if(s[i] == s[j]) {
            j = j+1;
            
        } else {
            let count = j-i;
            if(count == 1) {
                result.push(s[i]);
            } else {
                result.push(String(count), s[i]);
            }
            i = j;
        }
    }
    return result.join("");
}
// const str = compressVersion2('ccaaatsss'); // -> '2c3at3s'
const str = compressVersion2('ppoppppp'); // -> '2po5p'
// const str = compressVersion2('aaaab'); // -> '4a'

console.log(str);