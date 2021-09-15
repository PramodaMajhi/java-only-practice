/**
 * Write a function, binarySearch, that takes in a sorted array of numnbers and target.
 * The function should return the index where the target can be found within the array.
 * If the target is not found in  the array, then return -1
 * n = length of numbers array
    Time: O(logn)
    Space: O(1)

    binarySearch([0, 1, 2, 3, 4, 5, 6, 7, 8], 6); // -> 6
 */

const binarySearch = (numbers, target) => {

    return search(numbers, 0, numbers.length - 1, target)
    
}

const search = (numbers, low, high, target) => {

    if (low > high) {
        return -1;
    }

        let mid = low + Math.floor((high - low) / 2);
        if (target < numbers[mid]) {
            return search(numbers, low, mid - 1, target);;
        } else if (target > numbers[mid]) {
            return search(numbers, mid + 1, high, target)
        }
        else {
            return mid;
        }
    
    return -1;
}

 const position = binarySearch([0, 6, 8, 12, 16, 19, 20, 28], 12); // -> 2
// const position = binarySearch([0, 6, 8, 12, 16, 19, 20, 24, 28], 27); // -> -1

console.log(position);

