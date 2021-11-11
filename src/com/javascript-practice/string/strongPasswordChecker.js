/**
 * 420. Strong Password Checker
 * A password is considered strong if the below conditions are all met:

It has at least 6 characters and at most 20 characters.
It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.

In one step, you can:

Insert one character to password,
Delete one character from password, or
Replace one character of password with another character.
 */

// TBD - This is not complete yet

const strongPasswordChecker = (password) => {

    let digit = false, special = false , uppercase = false, lowercase= false;
    let repeat = false;
    let specials = "!~@#$%%^&*()";

    for(let i = 0 ; i < password.length; i ++) {
        let charCode = password.charCodeAt(i);
        if(charCode >= 65 && charCode <= 97) {
            uppercase = true;
        }
        if(charCode >= 97 && charCode <= 122) {
            lowercase = true;
        }
        if(charCode >= 48 && charCode <= 57) {
            digit = true;
        }
        let char = password.charAt(i);
        if(specials.includes(char)) {
            special = true;
        }
    }
    return `'Digit ' + ${digit} + 'Special ' ${special} + 'Uppercase ' ${uppercase} + 'Lowercase :'${lowercase}`
}

let password = "Password12";
console.log(strongPasswordChecker(password))