/**
 * Time complexity: O(K) where k = m+n
 * Space O(1)
 * @param {*} a 
 * @param {*} b 
 * @param {*} countA 
 * @param {*} countB 
 */

const mergeSortedArray = (a, b, countA, countB) => {

    let mergeIndex = countA + countB - 1;
    let lastElementOfA = countA - 1;
    let lastElementOfB = countB - 1;

    while (lastElementOfB >= 0) {
        if (lastElementOfA >= 0 && a[lastElementOfA] > b[lastElementOfB]) {

            a[mergeIndex] = a[lastElementOfA--];
           // lastElementOfA --;
        }
        else {
            a[mergeIndex] = b[lastElementOfB--];
           // lastElementOfB --;
        }
        mergeIndex--;
    }
   

}
const a = [5, 6, 0, 0];
const b = [4, 5];

console.log(mergeSortedArray(a, b, 2, 2))
console.log(a);