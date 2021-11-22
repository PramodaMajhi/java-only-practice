/**
 * 1221. Split a String in Balanced Strings
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
Given a balanced string s, split it in the maximum amount of balanced strings.
Return the maximum amount of split balanced strings.
  
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", 
each substring contains same number of 'L' and 'R'.


 */

const balancedStringSplit = (s) => {

    let balanced = 0;
    let count = 0;
    for (let i = 0; i < s.length; i++) {
        count += (s.charAt(i) == 'L') ? 1 : -1;
        if (count == 0)
            balanced++;
    }
    return balanced;
}

const balancedStringSplit2 = (s) => {

    let stack = [s[0]];
    let count = 0;
    for (let i = 1; i < s.length; i++) {
        if (s[i] == stack[stack.length - 1] || !stack.length)
            stack.push(s[i])
        else stack.pop();
        if (stack.length === 0) count++;
    }
    return count;
}

let s = "RLRRLLRLRL";
// Output: 4
console.log(
    balancedStringSplit(s),
    balancedStringSplit2(s)
    );