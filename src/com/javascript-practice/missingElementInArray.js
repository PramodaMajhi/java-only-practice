
const missingArray = (arr) => {

    const length = arr.length;
    let total = length * (length + 1) / 2; // Sum of natural numbers formula.
    for (const val of arr) {
        total = total - val;
    }
    return total;

}

const arr = [5, 3, 2, 0, 1];
console.log(missingArray(arr));