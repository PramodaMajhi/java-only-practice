class Node {
    constructor(val) {
      this.val = val;
      this.next = null;
    }
  }

const createLinkedList = (values, i = 0) => {
    if( i === values.length) return null;
    const head = new Node(values[i]);
    head.next = createLinkedList(values, i + 1);
    return head;
}

let head = createLinkedList(["h", "e", "y"]);
// h -> e -> y
console.log(head);
while(head!=null) {
    console.log(head.val);
    head  = head.next;
}