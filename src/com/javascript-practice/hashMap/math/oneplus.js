/**
 * You are given a large integer represented as an integer array digits, 
 * where each digits[i] is the ith digit of the integer. The digits are ordered 
 * from most significant to least significant in left-to-right order. 
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */

const plusOne = (digits) => {
    let carry = 1;
    let lastIndex = digits.length -1;
    while(lastIndex >= 0) {
       let sum = digits[lastIndex] + carry;
        console.log(Math.floor(sum/10));
        carry = Math.floor(sum/10);
        digits[lastIndex] = sum % 10;
        if(carry == 0) break;

        lastIndex --;
    }
    if(carry > 0) digits.unshift(carry);
    return digits;
    
}

let digits = [1,2,3];
console.log(plusOne(digits));