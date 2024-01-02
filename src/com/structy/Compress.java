package com.structy;

public class Compress {
    public String compress(String s){
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (j <= s.length()){
            if(j < s.length() && s.charAt(j) == s.charAt(i)  ) {
                j++;
            }else {
                int count  =  j - i;
                if(count != 1){
                    stringBuilder.append(count);
                }
                stringBuilder.append(s.charAt(i));
                i = j;
                if(i == s.length())
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        // I/O: 2c3at3s
        System.out.println(compress.compress("ppoppppp"));
    }
}
