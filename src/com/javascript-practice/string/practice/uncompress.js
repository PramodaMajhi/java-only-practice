const fiveSort = (nums) => {
    let firstIndex = 0;
    let lastIndex = nums.length - 1;
    while(firstIndex < lastIndex) {
        if(nums[lastIndex] === 5) {
            lastIndex--;
        } else if(nums[firstIndex] == 5){
            let temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            firstIndex++;
        }else {
            firstIndex++;
        }
    }
    return nums;
}
console.log(fiveSort([12, 5, 1, 5, 12, 7]));
// -> [12, 7, 1, 12, 5, 5] 

const compress = (s) => {
    let result = [];
    let i = 0;
    let j = 0;
    while(j <= s.length) {
        if(s.charAt(i) === s.charAt(j)) {
            j++
        } else {
            const num = j - i ;
            if(num == 1)result.push(s[i]);
            else result.push(String(num),s[i]);
            i = j;
        }
    }
    
   return result.join('');
};
//
//console.log(compress('ccaaatsss')); // -> '2c3at3s';
// ccaaatsss
//   ij    

const intersection = (a, b) => {
    let myset = new Set(a);
    let result = [];
    for(let num of b) {
      if(myset.has(num)) 
        result.push(num);
    }
    return result;

    
  };

  //console.log(intersection([4,2,1,6], [3,6,9,2,10]) )// -> [2,6]