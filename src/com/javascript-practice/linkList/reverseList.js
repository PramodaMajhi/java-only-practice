const reverseList = (head, prev=null) => {
    if(head === null) return prev;
    const next = head.next;
    head.next = prev;
     return reverseList(next, head);
  };

  class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

const x = new Node("x");
const y = new Node("y");

x.next = y;

// x -> y

reverseList(x); // y -> x