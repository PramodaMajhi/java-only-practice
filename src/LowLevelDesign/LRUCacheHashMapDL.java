package LowLevelDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheHashMapDL {
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCacheHashMapDL(int capacity){
        this.size = 0;
        this.capacity = capacity;
        // head.prev = null
        head = new DLinkedNode();
        // tail.next = null
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    private void removeNode(DLinkedNode node ){
       // Remove an existing node from the linked list.
        // How to remove existing node ?, get the prev and next pointer
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    // Always add the new node right after head
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    public void moveToHead( DLinkedNode node){
        // Move certain node in between to the head
        // First remove existing node
        removeNode(node);
        // Add node after removing it
        addNode(node);
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        // move the access node to head, because it used recently
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value){
        DLinkedNode node  = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if(size > capacity){
                // Remove from the tail
                DLinkedNode eldestNode = removeEldestNode();
                cache.remove(eldestNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private DLinkedNode removeEldestNode(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    public static void main(String[] args) {
        LRUCacheHashMapDL cacheHashMapDL = new LRUCacheHashMapDL(2);
        cacheHashMapDL.put(1,1);
        cacheHashMapDL.put(2,2);
        int key  = cacheHashMapDL.get(1);
        System.out.println("Get " + key);
        cacheHashMapDL.put(3,3); // LRU key was 2, evict key , cache is {1,1, 3,3}
        // System.out.println(cacheHashMapDL.cache.entrySet());
        for (Map.Entry<Integer, DLinkedNode> entry: cacheHashMapDL.cache.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue().value);
        }
        System.out.println(cacheHashMapDL.get(2)); // return -1
    }
}
