class Node {
    constructor(val) {
      this.val = val;
      this.next = null;
    }
  }
  
  const addLists = (head1, head2) => {
  
    // if(head1 == null || head1.next== null) {
    //     return head1;
    // }
    // let last = addLists(head1.next);
    //      head1.next.next = head1;
    //      head1.next = null;
    //      return last;
    let current = head1;
    let prev = null
    while(current!=null) {
        let next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
  };

//   621
// + 354
// -----
//   975

const a1 = new Node(1);
const a2 = new Node(2);
const a3 = new Node(6);
a1.next = a2;
a2.next = a3;
// 1 -> 2 -> 6

const b1 = new Node(4);
const b2 = new Node(5);
const b3 = new Node(3);
b1.next = b2;
b2.next = b3;
// 4 -> 5 -> 3

const a  = addLists(a1, b1);
console.log(a);

  