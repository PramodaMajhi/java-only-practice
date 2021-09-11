const maxValue = (nums) => {
    let max = -Infinity;
    for (let index = 0; index < nums.length; index++) {

        if(nums[index] > max) {
            max = nums[index];
        }
    }
    return max;
}

const max = maxValue([10, 5, 40, 40.3]); // -> 10
console.log(max);
// maxValue([10, 5, 40, 40.3]); // -> 40.3