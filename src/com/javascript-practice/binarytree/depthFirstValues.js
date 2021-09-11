/**
 * Write a function, depthFirstValues, that takes in the root of a binary tree. 
 * The function should return an array containing all values of the tree in 
 * depth-first order.
 * 
 * 
 * n = number of nodes
Time: O(n)
Space: O(n)
for both recursion and iterative
 */
class Node {
constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null
    }
}

const depthFirstValues = (root) => {
    if(root == null) return [];
    let values = [];
    let stack = [root];
    while(stack.length > 0) {
        let current  = stack.pop();
        values.push(current.val);
        if(current.right !== null) {
            stack.push(current.right);
        }
        if(current.left !== null) {
            stack.push(current.left);
        }
        
    }
    return values;
}


const a = new Node('a');
const b = new Node('b');
const c = new Node('c');
const d = new Node('d');
const e = new Node('e');
const f = new Node('f');

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

//      a
//    /   \
//   b     c
//  / \     \
// d   e     f


let values = depthFirstValues(a);
console.log(values);

const depthFirstValueRecurse = (root) =>  {
    if(root == null)  return [];
    let result = [];
    const leftValues = depthFirstValueRecurse(root.left);
    const rightValues =  depthFirstValueRecurse(root.right);
    result = [root.val, ...leftValues, ...rightValues];
    return result;
}
let recurseSol = depthFirstValueRecurse(a);
console.log(recurseSol);