
const fibo = (n) => {
    
    if(n<=2) {
        return 1;
    }
    let prevPrev =0;
    let  prev = 0;
    let current = 1;
   
    for (let i = 2; i <=n; i++) {
       prevPrev = prev;
       prev = current;
       current = prevPrev + prev;
    }
    return current;


}
/**
 * Complexity: O(2^n)
 * Space : O(n)
 * @param {*} n 
 * @returns 
 */
const fiboRecursive = (n) => {
   if(n <=2)
   return 1;

   return fiboRecursive(n-1) + fiboRecursive(n-2);


}
console.log(fibo(7));
// console.log(fiboRecursive(70));