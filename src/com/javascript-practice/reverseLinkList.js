/**
 * n = number of nodes
Time: O(n)
Space: O(1)
 * @param {*} head 
 * @returns 
 */
const reverseList = (head) => {
    // todo
    let current = head;
    let prev = null;
    while (current !== null) {
        const next = current.next;
        current.next = prev;
        prev = current;
        current = next;

    }
    return prev;
};