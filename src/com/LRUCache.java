package com;

import com.arrays.string.chapter1.Hash;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {
    // <String,Value>
    /**
     *
     */
    Set<HashMap<String, Object>> cache; // haskey generated out of string

    int capacity ;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashSet<HashMap<String, Object>>();
        this.capacity = capacity;
    }
    // This function returs false if key is not present in cache
    // It moves the key to front by first removing it then adding back to cache.
    public boolean get(int key) {
        if(!cache.contains(key)) {
            return false;
        }
        cache.remove(key);
        HashMap<String, Object> temp = new HashMap<>();

        cache.add(temp);

        return true;
    }

    public void put(int key) {
        if(cache.size() == capacity) {
            HashMap firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        HashMap<String, Object> newmap = new HashMap<>();
        // Generate a hashkey {
        /**
         * Class Person{
         * String name;
         * String addres;
         */
        newmap.put("key", new Object());
        cache.add(newmap);
    }
}
