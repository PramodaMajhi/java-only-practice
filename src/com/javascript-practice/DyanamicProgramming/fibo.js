/**
 * complexity:
 * Brute Force:
 * Each call does two recursive calls. This means that the runtime is O(2^n)
 * 
 * Memoized:
 * O(n) - Time
 * O(n) - Space
 * @param {*} n 
 * @param {*} memo 
 * @returns 
 */

const fibo = (n, memo ={}) => {
    if(n in memo) return memo[n];
    if(n <= 2)  return 1;
    memo[n] =  fibo(n-1, memo) + fibo(n-2, memo);
    return memo[n];

}

console.log(fibo(70));