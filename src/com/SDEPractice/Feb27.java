package com.SDEPractice;

public class Feb27 {
    public static void main(String[] args) {
        int num = 10;
      //  Output: "1a"
        System.out.println(toHex(num));
        decToHexa(num);
        System.out.println(toHex1(10));
    }
    /*
    IDEA: You can use Integer.toHexString() in built,
    but the problem said do not use in built

     */
    public static String toHex(int num) {
        return Integer.toHexString(num);
    }

    public static void  decToHexa(int num) {
        // create an array to store octal number
        int[] hexaArr = new int[100];

        // index for hexaArr
        int index = 0;
        while (num!=0) {
            // storing the remainder in array
            hexaArr[index] = num % 16;
            num = num / 16;
            index ++;
        }
        // printing the number in reverse order
        for (int i = index -1; i >= 0; i--) {
            if(hexaArr[i] > 9) {
                System.out.println((char)(55 + hexaArr[i]));
            }
            else System.out.println(hexaArr[i]);
        }

    }
 /*
    Basic idea: each time we take a look at the last four digits of
    binary verion of the input, and maps that to a hex char
    shift the input to the right by 4 bits, do it again
    until input becomes 0.

    */
    public static String toHex1(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
