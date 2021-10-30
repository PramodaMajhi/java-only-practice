const fiveSort = (nums) => {
    let firstIndex = 0;
    let lastIndex = nums.length - 1;
    while (firstIndex < lastIndex) {
        if (nums[lastIndex] === 5) {
            lastIndex--;
        } else if (nums[firstIndex] === 5) {
            let temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex]; // copy
            nums[lastIndex] = temp;
            firstIndex++;
        } else {
            firstIndex++;
        }

    }
    return nums;
};



console.log(fiveSort([5, 2, 5, 6, 5, 1, 10, 2, 5, 5])); // -> [12, 7, 1, 12, 5, 5] 