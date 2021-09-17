
const missingArray = (arr) => {

    // const length = arr.length+1;
    const length = arr.length;
    // (n+1) * (n+2) /2
    // n* (n+1)/
    let total = Math.floor(length +1) * (length + 2) / 2; // Sum of natural numbers formula.
  //  let total = Math.floor(length) * (length +1) / 2; // Sum of natural numbers formula.

    let sum = 0;
    for (const val of arr) {
        total = total - val;
    }
    return total;

}

const arr = [1, 2, 4, 6, 3, 7, 8];
console.log(missingArray(arr));