
const removeNodeRecursive = (node, target) => {

    if(node === null) return null;
    if(node.val === target) 
    return node.next;
    
    node.next = removeNodeRecursive(node.next, target);
    return node;

}



const removeNode = (node, target) => {

    if(node.val === target) return node.next;

    let current = node ;
    let prev = null;
    while(current!=null) {

        if(current.val === target) {
            prev.next = current.next;
            break;
        }
         prev = current;
         current = current.next;

    }
    return node;
}

class Node {
    constructor(val) {
        this.val  = val;
        this.next = null;
    }
}
const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");
const e = new Node("e");
const f = new Node("f");

a.next = b;
b.next = c;
c.next = d;
d.next = e;
e.next = f;

// a -> b -> c -> d -> e -> f

// let result  = removeNode(a, "c");
let result  = removeNodeRecursive(a, "b");
// a -> b -> d -> e -> f
while(result!==null) {
    console.log(result.val);
    result = result.next;
}