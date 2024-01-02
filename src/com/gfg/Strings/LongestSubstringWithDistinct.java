package com.gfg.Strings;

public class LongestSubstringWithDistinct {
    public int longestDistinct(String str){
        int res = 0;
        for (int i = 0; i < str.length() ; i++) {
            for (int j = i; j < str.length(); j++) {
                if(areDistinct(str,i,j)){
                    res = Math.max(res, j - i +1);
                }
            }
        }
        return res;
    }

    private boolean areDistinct(String str, int i, int j){
        boolean visited[] = new boolean[256];
        for (int k = i; k <=j; k++) {
            if(visited[str.charAt(k)] == true)
            {
                return false;
            }
            visited[str.charAt(k)] = true;
        }
        return true;
    }
    public int longestDistinctBetter(String str){
        int res = 0;
        for (int i = 0; i < str.length() ; i++) {
            boolean[]visited = new boolean[256];
            for (int j = i; j < str.length(); j++) {
                    if(visited[str.charAt(j)] == true){
                        break;
                    } else {
                        res = Math.max(res, j - i +1);
                        visited[str.charAt(j)] = true;
                    }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LongestSubstringWithDistinct obj = new LongestSubstringWithDistinct();
        System.out.println(obj.longestDistinct("abac"));
        System.out.println(obj.longestDistinctBetter("abac"));
    }
}
