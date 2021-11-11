/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
   Each root-to-leaf path in the tree represents a number.
   For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
   Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
   A leaf node is a node with no children.
 */


class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

const a = new Node(1);
const b = new Node(2);
const c = new Node(3);


a.left = b;
a.right = c;

const sumroot = (root) => {

    return helper(root);

}
const helper = (root, curVal = 0) => {
    if (root == null) return 0;
       
        curVal = curVal*10 + root.val;

    if (root.left == null && root.right == null) {
        return curVal;
    }
    console.log(curVal);
    let left = helper(root.left, curVal);
    let right = helper(root.right, curVal);
    return left + right;
}
console.log(sumroot(a));
