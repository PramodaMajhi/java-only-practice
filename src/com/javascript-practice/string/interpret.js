/**
 * 1678. Goal Parser Interpretation
You own a Goal Parser that can interpret a string command. 
The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" 
as the string "al". The interpreted strings are then concatenated in the original order.
Given the string command, return the Goal Parser's interpretation of command.

Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
 */
const interpret = (command) => {
    let i = 0;
    let result = [];
    while(i < command.length) {
        if(command[i] == 'G') {
            result.push('G');
            i++;
        }
        if(command[i] == '(') {
            if(command[i+1] == ')') {
                result.push('o'); 
                i+=2;
            } else {
                result.push('al');
                i+=4;
            }
        }
    }
    return result.join('');
}
// let command = "G()(al)";
// output "Goal"
let command = "G()()()()(al)" ;
console.log(interpret(command));