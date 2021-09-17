class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

const a  = new Node("1");
const b  = new Node("0");
const c  = new Node("0");
const d  = new Node("1");
// const e  = new Node("7");
a.next = b;
b.next = c;
c.next = d;
// d.next = e;

const  isPalindrome = (head) => {
    let fast = head;
    let slow = head;
    const stack = [];
    while(fast!=null && fast.next!=null) {
        stack.push(slow.val);
        slow = slow.next;
        fast = fast.next.next;
    }
    // Has odd number of element in the list, we don't have to compare the middle element.
     if(fast!=null) {
         slow =slow.next;
     }
    
    while(slow!=null) {
        const stackTopElem  = stack.pop();
        if(stackTopElem != slow.val) {
            return false
        }

        slow = slow.next;
    }
 return true;
    
}


console.log(isPalindrome(a));