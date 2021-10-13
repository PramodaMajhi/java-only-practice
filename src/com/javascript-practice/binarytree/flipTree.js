/*
    Write a funtion, flipTree, that takes in the root of a binary tree.
    The function should flip the binary tree, turning left subtrees into right subtrees and vice-versa
    This flipping should occur in place by modifying the original tree.

    n = number of nodes
Time: O(n)
Space: O(n)

/**
 * //    a
//    /    \
//   b      c
//  / \      \
// d   e      f
//    / \
//    g  h

flipTree(a); 

//       a
//    /    \
//   c      b
//  /     /   \
// f     e    d
//     /  \
//    h    g

Note: 
(a) Inorder (Left, Root, Right) 
(b) Preorder (Root, Left, Right) 
(c) Postorder (Left, Right, Root)
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
const g = new Node("g");
const h = new Node("h");

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;
e.left = g;
e.right = h;

//      a
//    /    \
//   b      c
//  / \      \
// d   e      f
//    / \
//    g  h

const flipTree = (root) => {

    if(root == null)  return ;
    const left =  flipTree(root.left);
    const right = flipTree(root.right);
  // flip at each root node.
    root.left = right;
    root.right = left;

    
     return root;
}

const afterFlip = flipTree(a);


const printPreOrder = (root) => {
    const p = root;
    if(p !=null) {
        console.log(p.val);
        if(p.left) {
            printPreOrder(p.left);
        }if(p.right) {
            printPreOrder(p.right);
        }
    }
}
printPreOrder(afterFlip);
