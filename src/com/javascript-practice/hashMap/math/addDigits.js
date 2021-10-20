const addDigits = (num) => {
    
    // 38
    let sum = 0;
    let reminder =0 ;
    while(num > 0) {
        reminder = num%10;
        sum = sum +reminder;
        num = Math.floor(num /10);
        if(num === 0 && sum > 9) {
            num = sum;
            sum = 0;
        }
    }
    return sum;
    
};

// console.log(addDigits(38));

const secondApproachAddDigits = (num) => {
    
    // 38
    return num === 0 ? 0 : 1 + (num-1)% 9;
    
};

console.log(secondApproachAddDigits(38));
