class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

const isUnivalueList = (head, prev = null) => {
    if (head == null) return true;

    if (prev !== null && prev !== head.val) return false;
    return isUnivalueList(head.next, head.val)
};

const a = new Node(7);
const b = new Node(7);
const c = new Node(4);

a.next = b;
b.next = c;

// 7 -> 7 -> 7

console.log(isUnivalueList(a)); // true