package com.SDEPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    private HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    // Initialize your data structure here
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }
    /**
     Insert a value to the set. returns true if the set set did not already contain
     the specified element
     **/
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    /**
     Removes a value from the set. Returns true of the set contained the specified element
     **/
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        // move the last element to the place idx of the element to be deleted
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);

        // Now  can be deleted safely
        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }

    /**
     Get a random element from the set
     **/
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(51);
        randomizedSet.insert(2);
        randomizedSet.insert(10);
        randomizedSet.insert(63);
        randomizedSet.insert(57);
        randomizedSet.remove(10);

    }
}
