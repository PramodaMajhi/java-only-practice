package com.SDEPractice;

public class Feb10 {

    public static void main(String[] args) {
        System.out.println(thousandSeparator(1541));
        System.out.println(thousandOperator1(787));
    }
    /*
    1556. Thousand Separator
     */
    public static String thousandSeparator(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        //first get num as string
        String num = Integer.toString(n);
        for (int i = 0; i <num.length() ; i++) {
            //if the digit index divisible to three add seperator
            if(i>0 && (num.length() - i) %3 == 0) {
                stringBuilder.append(".");
            }
            //always add the number
            stringBuilder.append(num.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String thousandOperator1(int n){
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(n));
        for (int i = stringBuilder.length() - 3; i >0 ; i-=3) {
            stringBuilder.insert(i,".");
        }
        return stringBuilder.toString();
    }
}
