/**
 * tree includes
Write a function, treeIncludes, that takes in the root of a binary tree and a target value. 
The function should return a boolean indicating whether or not the value is contained 
in the tree.
 * @param {*} root 
 * @param {*} target 
 * @returns 
 */

const treeIncludes = (root, target) => {

    if (root === null) return false;

    let stack = [root];

    while (stack.length > 0) {

        let node = stack.pop();
        if (node.val === target) return true;
        if (node.left !== null) stack.push(node.left);
        if (node.right !== null) stack.push(node.right);
    }
    return false;

};

class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");
const e = new Node("e");
const f = new Node("f");

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

// console.log(treeIncludes(a, "e")); // -> true

const treeIncludesRecursion = (root, target) => {

    if (root == null) return false;
    if (root.val == target) return true;

    return treeIncludesRecursion(root.left, target) || treeIncludesRecursion(root.right, target);
}

console.log(treeIncludesRecursion(a, "e")); // -> true