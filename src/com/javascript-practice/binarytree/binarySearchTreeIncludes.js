/**
 * Write a function binarySearchTreeIncludes, that takes in the root of a binary
 * search tree containing numbers and a target value. The function should return 
 * a boolean indicating whether or not the target is found within a tree.
 * 
 * n = number of nodes

Worst Case

Time: O(n)
Space: O(n)
Best Case (balanced-tree)

Time: O(log(n))
Space: O(log(n))
 */

class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
const a = new Node(12);
const b = new Node(5);
const c = new Node(18);
const d = new Node(3);
const e = new Node(9);
const f = new Node(19);

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

//      12
//    /   \
//   5     18
//  / \     \
// 3   9     19
const binarySearchTreeIncludes = (root, target) => {

    if(root == null) {
        return false;
    }

    if(target < root.val) {
        return binarySearchTreeIncludes(root.left, target)
    }
    else if(target > root.val) {
        return binarySearchTreeIncludes(root.right, target)
    }
    else {
        return true;
    }
}

const  found  = binarySearchTreeIncludes(a, 9); // -> true
console.log(found);