/**
 *  Write a function, treeMinValue, that takes in the root of a binary
 * tree that contains number values. The function should return the minimum
 *  value within the tree.

You may assume that the input tree is non-empty.
n = number of nodes
Time: O(n)
Space: O(n)
 */

class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

const a = new Node(5);
const b = new Node(11);
const c = new Node(3);
const d = new Node(4);
const e = new Node(14);
const f = new Node(12);

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

//       5
//    /    \
//   11     3
//  / \      \
// 4   15     12

// in this case ->3
const treeMinValue = (a) => {

// let solve this issue using recursions, also depth first search
 if(a == null) return Infinity;
const smallestLeft = treeMinValue(a.left);
const smallestRight = treeMinValue(a.right);

return Math.min(a.val, smallestLeft, smallestRight);

};
const minValue  = treeMinValue(a);
console.log(minValue);

// depth first search iterative 

const treeMinValueDfs = (a) => {
    
}