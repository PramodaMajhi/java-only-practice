/**
 * Write a function, linkedListValues, that takes in the head of a 
 * linked list as an argument. The function should return an array 
 * containing all values of the nodes in the linked list.
 */

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

const linkedListValues = (head) => {
    const a = new Node("a");
    const b = new Node("b");
    const c = new Node("c");
    const d = new Node("d");

    a.next = b;
    b.next = c;
    c.next = d;
    let current  = head;
    let values = [];
    while (current!=null) {
        console.log(current.val);
        values.push(current.val);
        current = current.next;

    }
    return values;
};
linkedListValues("head");