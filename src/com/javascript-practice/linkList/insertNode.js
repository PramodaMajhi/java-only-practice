class Node {
    constructor(val) {
      this.val = val;
      this.next = null;
    }
  }
  
  const insertNode = (head, value, index) => {

    if(head === null) return head;
    if(head !=null && index === 0) {
        let insert = new Node(value);
        insert.next = head;
        return insert;
    }

    let count = 0;
    let current  = head;
    
    while(current!=null) {
        
        if(count === index - 1) {
            let temp = current.next;
            let insertedName = new Node(value);
            current.next = insertedName;
            current.next.next = temp;
        }
        count ++;
        current = current.next;
    }
    return head;
  };
  const a = new Node("a");
  const b = new Node("b");
  const c = new Node("c");
  const d = new Node("d");
  
  a.next = b;
  b.next = c;
  c.next = d;
  
  // a -> b -> c -> d
  
  let result = insertNode(a, 'x', 2);
  // a -> b -> x -> c -> d  
 while(result!=null) {
     console.log(result.val);
     result  = result.next;
 }