const linkedListValues = (head, result) => {
   // let result = [];

    if(head === null) return
   //  _linkedValues(head,result);
   let val = head.val;
   result.push(val);
   linkedListValues(head.next, result);

    return result

}
const _linkedValues = (head, result) => {
    if (head === null) return;
        result.push(head.val);
        _linkedValues(head.next, result);

}

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");

a.next = b;
b.next = c;
c.next = d;

// a -> b -> c -> d
let result = [];
console.log(linkedListValues(a, result)); // -> [ 'a', 'b', 'c', 'd' ]