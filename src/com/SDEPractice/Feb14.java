package com.SDEPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Feb14 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        //  System.out.println(lemonadeChange(bills));
        Integer[][] rooms = {{1}, {2}, {3}, {}};
        List<List<Integer>> roomList = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(canVisitAllRooms(roomList));
    }
    /*
     841. Keys and Rooms
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[]  seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        // At the beginning, we have todo list "stack" of keys to use
        // seen represent at some point we have entered into that room
        while(!stack.isEmpty()) { // while we have keys
            int room = stack.pop();
            for (int nei: rooms.get(room)) { // for every key in the room
                if(!seen[nei]) {
                    seen[nei] = true;
                    stack.push(nei);
                }
            }
        }
        for (boolean v : seen) { // if any room hasn't been visited, return false
            if(!v) return false;
        }
        return true;
    }
    public boolean canVisitAllRoomsDfs(List<List<Integer>> rooms) {
        //rooms -- index is node, each list in it is the index's neighbors
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();

    }

    public void dfs(List<List<Integer>> rooms, int n, Set<Integer> visited) {
        visited.add(n);
        for (int nei : rooms.get(n)) {
            if (!visited.contains(nei)) {
                dfs(rooms, nei, visited);
            }
        }
    }
    /*
      860. Lemonade Change
      IDEA: When customer gives you $20, we have two options
        1) To give three $5 in return
        2) To give one $5 and one $10 -
            This option is better because more change in our hand is always better.
        Count the number of 5 and 10 in hand

     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
