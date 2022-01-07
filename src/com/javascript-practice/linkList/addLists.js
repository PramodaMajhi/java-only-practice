class Node {
    constructor(val) {
      this.val = val;
      this.next = null;
    }
  }
  
  const addLists = (head1, head2) => {
    let dummyHead = new Node(0);
    
    let tail = dummyHead;
    let current1 = head1;
    let current2 = head2 ;
    let sum = 0;
    let remainder = 0;
    while(current1!==null || current2!==null || remainder!== 0) {
      const val1 = current1 === null ? 0 : current1.val;
      const val2 = current2 === null ? 0 : current2.val;
      sum = remainder + val1 + val2;
      remainder = sum >= 10 ? 1 : 0;
      sum = sum % 10;
      tail.next = new Node(sum);
      tail = tail.next;
      if(current1 !== null) current1 = current1.next;
      if(current2 !== null) current2 = current2.next;
    }
    return dummyHead.next;
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

  