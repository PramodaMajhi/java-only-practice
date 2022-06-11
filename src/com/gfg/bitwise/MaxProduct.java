package com.gfg.bitwise;

public class MaxProduct {

    public int maxProduct(String[] words) {
        int n  = words.length;
        int[]masks = new int[n];
        int[]lens = new int[n];
        int bitmask = 0;
        for (int i = 0; i < n; i++) {
            bitmask = 0;
            for (char ch: words[i].toCharArray()) {
                // add bit number in bitmask
                bitmask|= 1<<getBitNumber(ch);
            }
            masks[i] = bitmask;
            lens[i] = words.length;
        }
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((masks[i] & masks[j]) == 0)
                    maxVal = Math.max(maxVal, lens[i]* lens[j]);
            }
        }
        return maxVal;
    }
    public int getBitNumber(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        String[]words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int ans = maxProduct.maxProduct(words);
        System.out.println(ans);
    }
}
