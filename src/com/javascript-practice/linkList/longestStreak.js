

const longestStreak = (node) => {
    let max = 0;
    if(node == null)  return max;
    let firstVal = null;
    let count = 0;
    let current  = node;
    while(current!=null) {
        if(firstVal == current.val) {
            firstVal = current.val;
            count ++;
        }else {
            count = 1;
            firstVal = current.val;
        }
        if(count > max) {
            max = count;
        }
        current = current.next;
    }
    return max;
    
}




class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
const a = new Node(5);
const b = new Node(5);
// const c = new Node(7);
// const d = new Node(7);
// const e = new Node(7);
// const f = new Node(6);

a.next = b;
// b.next = c;
// c.next = d;
// d.next = e;
// e.next = f;

// 5 -> 5 -> 7 -> 7 -> 7 -> 6

let result = longestStreak(a); // 2
console.log(result);