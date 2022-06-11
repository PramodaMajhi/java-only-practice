package LowLevelDesign;

import java.util.LinkedHashMap;
import java.util.Map;
// https://leetcode.com/problems/lru-cache/submissions/
public class LRUCache extends  LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        /*
        Constructs an empty LinkedHashMap instance with the specified initial capacity,
        load factor and ordering mode.
        accessOrder – the ordering mode - true for access-order, false for insertion-order
        A special constructor is provided to create a linked hash map whose order of iteration
        is the order in which its entries were last accessed, from least-recently accessed
        to most-recently (access-order)
       */
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
