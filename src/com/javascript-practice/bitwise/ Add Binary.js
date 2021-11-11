/**
 * Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

const addBinary = (a, b) => {

    let binarySum = 0;

    let x = parseInt(a, 2);
    let y = parseInt(b, 2);
    binarySum = x + y;
    binarySum = Number(binarySum).toString(2);
    return binarySum;
}
const addBinary2 = (a, b) => {
    // 0b or 0B means binary literasl 
    // A binary literal is a number that is represented in 0s and 1s (binary digits). 
    const aBin = `0B${a}`
    const bBin = `0B${b}`
    const sum = BigInt(aBin) + BigInt(bBin);
  
    return sum.toString(2);
}

const addBinary3 = (a, b) => {

    let sum = ''; // solution to be string.
    let carry = 0;
    let i = a.length - 1;
    let j = b.length - 1;

    while (j >= 0 || i >= 0) {
    let A = a[i] ? a[i]: '0';
    let B = b[j] ? b[j] : '0';
    sum = String (A ^ B ^ carry) + sum;
    if(A === B && A!=String(carry)) {
        carry = Number(!carry);
    }
    i --;
    j --;
    }
    if(carry) {
        sum = String(carry) + sum;
    }
    return sum;
}

// let a = "1010", b = "1011";
let a = "11", b = "1"


console.log(
    addBinary(a, b),
    addBinary2(a, b),
    addBinary3(a, b)
)