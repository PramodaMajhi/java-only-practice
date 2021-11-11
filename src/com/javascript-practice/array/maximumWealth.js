/**
 * 1672. Richest Customer Wealth
 * You are given an m x n integer grid accounts where accounts[i][j] 
 * is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank.
 *  Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. 
The richest customer is the customer that has the maximum wealth.
 * @param {*} accounts 
 */
const maximumWealth = (accounts) => {
    let max = -Infinity;
    for(let ac of accounts) {
        let sum = 0;
        for (const item of ac) {
            sum += item;
        }
       max =  Math.max(sum, max);
    }
    return max;
}

const maximumWealth2 = (accounts) => {
    let max = -Infinity;
    accounts.forEach(element => {
      const total = element.reduce((x,y) => x+y);
      if(total > max) max = total;

  });
  return max;
}

// let accounts = [[1,2,3],[3,2,1]] ;
let accounts  = [[2,8,7],[7,1,3],[1,9,5]] ; // [[1,5],[7,3],[3,5]];

console.log(maximumWealth(accounts),
maximumWealth2(accounts));