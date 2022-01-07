package com.SDEPractice;

import java.util.*;

public class RandomizedCollection {
    private ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Set<Integer>>();
    }
    /** Inserts a value to the collection.
     * Returns true if the collection did not
     * already contain the specified element. */
    public boolean insert(int val) {
        /* if(!map.containsKey(val)) {
            map.put(val, new HashSet<Integer>());
        }
        // All we have to do is have an accompanying
        // data structure that maps the element values to their index.
         map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1; */
        boolean res = !map.containsKey(val);

        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        list.add(val);
        map.put(val, set);
        return res;
    }
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
      /*  if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        int remove_idx = map.get(val).iterator().next();
        map.get(val).remove(remove_idx);
        int last  = list.get(list.size() -1);
        list.set(remove_idx, last);
        map.get(last).add(remove_idx);
        map.get(last).remove(list.size() -1);
        list.remove(list.size() -1);
        return true; */
        if(!map.containsKey(val)) return false;

        //if valIndex is the last index, just need to remove it
        // from list and val index from map
        int valIndex = map.get(val).iterator().next();//.iterator().next();
        map.get(val).remove(valIndex);

        //if valIndex is not the last index, need to replace val
        // with the last value at valIndex
        int lastIndex = list.size()-1;
        if (valIndex < lastIndex) {
            int lastVal = list.get(lastIndex);
            list.set(valIndex, lastVal);
            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(valIndex);
        }

        list.remove(list.size()-1);
        //remove from hashmap if set is empty
        if (map.get(val).isEmpty())
            map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.remove(1));
    }
}
