package com.arrays.practiceproblem;
import  java.util.*;

public class MapPractice {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String,String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        map.put("d","hi");
        System.out.println(mapShare(map));
    }

    /**
     * mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
     * mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
     * mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
     * @param map
     * @return
     */
    public static Map<String, String> mapShare(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b") && map.containsKey("c")) {
            String avalue = map.get("a");
            String bvalue = map.get("b");
            map.put("a", bvalue);
            map.put("b", avalue);
            map.remove("c");
        }
        return map;
    }
}
