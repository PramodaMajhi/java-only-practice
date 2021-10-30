const mergeLists = (A, B) => {
    let dummyHead = new Node('0');
    let tail = dummyHead;
    while(A!=null && B!=null) {
        if(A.val <= B.val) {
        tail.next = A;
        A = A.next;
        } else {
            tail.next = B;
            B = B.next;
        }
        tail = tail.next;
    }
    if(A!=null) {
        tail.next = A;
    }
    if(B!=null) {
        tail.next = B;
    }

    return dummyHead.next;
}




class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
const a = new Node(5);
const b = new Node(7);
const c = new Node(10);
const d = new Node(12);
const e = new Node(20);
const f = new Node(28);
a.next = b;
b.next = c;
c.next = d;
d.next = e;
e.next = f;
// 5 -> 7 -> 10 -> 12 -> 20 -> 28

const q = new Node(6);
const r = new Node(8);
const s = new Node(9);
const t = new Node(25);
q.next = r;
r.next = s;
s.next = t;
// 6 -> 8 -> 9 -> 25

let result = mergeLists(a, q);
while(result!=null) {
    console.log(result.val);
    result  = result.next;
}