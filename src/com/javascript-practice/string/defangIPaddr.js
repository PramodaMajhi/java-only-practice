/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".
 * @param {*} address 
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
 */
const defangIPaddr = (address) => {
    let final = [];
    for(let i=0; i < address.length; i ++) {
        if(address.charAt(i) === '.') {
            final.push('[.]');
        }else {
            final.push(address.charAt(i));
        }
    }
    return final.join('');

}

const defangIPaddr2 = (address) => {
    return address.split('.').join('[.]');

}
let address = "1.1.1.1" ;
console.log(
    defangIPaddr(address),
    defangIPaddr2(address)
    )