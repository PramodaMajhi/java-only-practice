/**
 * Write a function, pathFinder, thats takes in the root of a binary tree and a target value.
 * The function should return an array representing a path to the target value.
 * if target value is not found in the tree, then return null.
 * 
 * you may assume that the tree containe unique values.
 * 
//      a
//    /   \
//   b     c
//  / \     \
// d   e     f

    pathFinder(a, 'e'); // -> [ 'a', 'b', 'e' ]
 */

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


    const pathFinder = (root, target) => {
        const result = pathHelper(root, target);
        
        return result ? result.reverse() : null;
    }

    const pathHelper = (root, target) =>  {
        if(root == null) return null;

        if(target == root.val) return [root.val];
        const leftPath = pathHelper(root.left, target);
        if(leftPath!=null) {
            leftPath.push(root.val);
            return leftPath; // does not give the order we expect
        }
        const rightPath = pathHelper(root.right, target);
        if(rightPath!=null) {
            rightPath.push(root.val);
            return rightPath; // does not give the order we expect
        }
        return null;
    }


const result = pathFinder(a, 'e'); // -> [ 'a', 'b', 'e' ]
console.log(result);