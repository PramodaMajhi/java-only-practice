/**
 * n = input number
Time: O(square_root(n))
Space: O(1)
 */
isPrime = (n) => {
    if (n < 2) {
        return false;
    }
    let upto = Math.sqrt(n);
    for (let i = 2; i <= upto; i++) {
        if (n % i == 0) return false;
    }
    return true;
};

console.log('Output is ->    '+ isPrime(7));