var addTwoNumbers = (l1, l2) =>  {
    let remainder = 0;
    let sum  = 0 ;
    let current  = new Node(0);
    let result = current;
    while(l1!=null || l2 != null) {
        
        sum  = remainder + (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) ;
        
        remainder  = sum >=10 ? 1 : 0;
        sum = sum % 10;
        
        current.next = new Node(sum);
        current = current.next;
        
        if(l1!=null) {
           l1 =  l1.next;
        }
        
        if(l2!=null) {
           l2 =  l2.next;
        }
        
    }
    if(remainder > 0) {
        current.next = new Node(remainder);
    }
    return result.next;
};

class Node {
    constructor(val) {
      this.val = val;
      this.next = null
    }
  }

const a = new Node(1);
const b = new Node(2);
a.next = b;

const c = new Node(3);
const d = new Node(3);
c.next = d;
addTwoNumbers(a,c);