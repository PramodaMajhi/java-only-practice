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
    if (a == null) return Infinity;
    const smallestLeft = treeMinValue(a.left);
    const smallestRight = treeMinValue(a.right);

    return Math.min(a.val, smallestLeft, smallestRight);

};
const minValue = treeMinValue(a);
console.log(minValue);

// depth first search iterative 
// DFS = Stack
const treeMinValueDfs = (root) => {
    let stack = [root];
    let smallest = Infinity;
    while(stack.length > 0) {
        let current = stack.pop();
        if(current.val < smallest) {
            smallest = current.val;
        } 
        if(current.left !== null) stack.push(current.left);
        if(current.right !=null) stack.push(current.right);

    }
    return smallest;
}

const dfsMin = treeMinValueDfs(a);
console.log(dfsMin);

// BFS solution .. Queue  , we can't solve using recursive
// Only solution we have is iterative

/**
 * n = number of nodes
Time: O(n)
Space: O(n)
Note: this solution should really be considered O(n^2) runtime because 
the JavaScript shift() methods runs in O(n). 
JavaScript does not have a native queue data structure that is maximally efficient.
 * @param {*} root 
 * @returns 
 */
const bsfTreeMin = (root) => {
    
    const queue = [root];
    let smallest = Infinity;
    while(queue.length > 0) {
        /**
         * The shift() method removes the first element 
         * from an array and returns that removed element. 
         * This method changes the length of the array.
         */
        let current = queue.shift();// get the element from queue.
        if(current.val < smallest) {
            smallest = current.val;
        }
        if(current.left !== null) queue.push(current.left);
        if(current.right !== null) queue.push(current.right);
    }
    return smallest;
};
const bsf = bsfTreeMin(a);
console.log(bsf);