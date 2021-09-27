/**
merge sort
Write a function, mergeSort, that takes in an array of numbers as an argument.
The function should return return a new array containing elements of the original
array sorted in ascending order. Your function must implement the merge sort algorithm.

n = array size
Time: O(nlogn)
Space: O(n)
 */

const mergeSort = (nums) => {

    if(nums.length <= 1 ) return nums;
    
    let mid =  Math.floor(nums.length/2);
    let left  = nums.slice(0, mid);
    let right  = nums.slice(mid);
    let leftSorted = mergeSort(left);
    let rightSorted = mergeSort(right);
  
    return merge(leftSorted,rightSorted);

}

const merge = (array1, array2) => {

    array1.reverse(); // when we compare the with the first element using shift()
                    /**
                     * all the element to push to the left, which is lenear time, 
                     * we need to pop() to get the optimized performance.
                     * Now will compare last two element because we reverse the array
                     * nlogn
                     */
    array2.reverse();

    const merged = [];

    while(array1.length > 0  && array2.length > 0) {
        if(array1[array1.length - 1] < array2[array2.length -1 ]) {
            merged.push(array1.pop());
        } else {
            merged.push(array2.pop());
        }
    }
    merged.push(...array1.reverse()); // reverting to ascending order
    merged.push(...array2.reverse());
    return  merged;
}

const numbers = [10, 4, 42, 5, 8, 100, 5, 6, 12, 40];
const merged = mergeSort(numbers);
// -> [ 4, 5, 5, 6, 8, 10, 12, 40, 42, 100 ] 
console.log(merged);