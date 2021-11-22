package com.arrays.practiceproblem;

import java.util.Locale;

public class String2Practice {
    public static void main(String[] args) {
        //System.out.println(doubleChar("The"));
       // System.out.println(countHi("abchiho"));
        // System.out.println(catDog("catdog"));
       // System.out.println(countCode("cozexxcope"));
       // System.out.println(endOther("AbC", "HiaBc"));
        //System.out.println(xyzThere(".xyz"));
      //  System.out.println(mixString("ax", "b"));
       // System.out.println(repeatFront("Ice Cream", 2));
       // System.out.println(xyzMiddle("AxyzBBB"));
       // System.out.println(getSandwich("breadjambread"));
        System.out.println(sameStarChar("*xa*az"));
    }
    public static boolean sameStarChar(String str) {
        if(str.length() == 0) return  false;
        for (int i = 0; i < str.length(); i++) {
            if(i!=0 && str.charAt(i) == '*') {
                if(str.charAt(i-1) == str.charAt(i+1)) return  true;
            }
        }
        return false;
    }
    public static String getSandwich(String str) {
        int i = -1;
        int j = -1;
        for (int k = 0; k < str.length()-5; k++) {
            if(str.substring(k,k+5).equals("bread")) {
                i = k;
                break;
            }
        }
        for (int k = str.length()-5; k >=0; k--) {
            if(str.substring(k, k+5).equals("bread")) {
               j =k;
               break;
            }

        }
        if(i != -1 && j!=-1 && i!=j) {
            return  str.substring(i+5, j);
        }
        return "";
    }
    public static boolean xyzMiddle(String str) {
        int mid = str.length()/2;
        int start1 = str.length()/2-2;
        int start2 = str.length()/2-1;
        if(str.charAt(mid -1) == 'x' && str.charAt(mid) == 'y' && str.charAt(mid+1) == 'z') {
            return true;
        }
        System.out.println(str.charAt(mid));
        return false;
    }
    public static String repeatFront(String str, int n) {
        StringBuffer sb = new StringBuffer();
        for(int i = n ; i > 0; i--) {
            sb.append(str.substring(0,i));
        }
        return sb.toString();
    }
    public static String mixString(String a, String b) {
        if(a.length() == 0 ) return b;
        if(b.length() == 0 ) return a;
        String leftOver;
        String result = "";
        int min = Math.min(a.length(), b.length());
        if(a.length() > b.length()) {
          leftOver = a.substring(b.length());
        } else {
            leftOver = b.substring(a.length());
        }
        for(int i =0 ; i < min; i++){
            result+= Character.toString(a.charAt(i))+
                    Character.toString(b.charAt(i));
        }

        return result +leftOver;
    }
    public boolean bobThere(String str) {

        for(int i = 0 ; i < str.length() -2; i++ ) {
            if(str.charAt(i)=='b'&& str.charAt(i+2) =='b')
            {
                return true;
            }

        }
        return false;
    }
    public static boolean xyzThere(String str) {
        if(str.length() >=3 && str.substring(0,3).equals("xyz")) {
            return  true;
        }
        for(int i=1 ; i <str.length() - 2; i ++) {
            char c = str.charAt(i-1);
            String subString = str.substring(i,i+3);
            if( c != '.' && subString.equals("xyz"))
                return  true;
        }

       return false;
    }
    public static  boolean endOther(String a, String b) {
        if(a.length() > b.length()){
            String first = a.substring(a.length() - b.length()).toLowerCase();
            String second  = b.toLowerCase();
            if(first.equals(second)) return  true;

        } else {
            String second = b.substring(b.length() -a.length()).toLowerCase();
            String first  = a.toLowerCase();
            if(second.equals(first)) return  true;
        }
        return  false;
    }
   //cozexxcope -> 2
    public static int countCode(String str) {
        int count = 0;
//        int start = str.indexOf("code", 0);;
//        while (start != -1) {
//            count++;
//            start = str.indexOf("code", start + 1);
//        }
        for(int i = 0 ; i < str.length() -3; i++ ) {
            if(str.substring(i, i+2).equals("co") && str.charAt(i+3)==('e'))
                count++;
        }
        return  count;

    }
    public static boolean catDog(String str) {
        int dcount =0 ;
        int ccount = 0;
        for(int i = 0; i < str.length() -2; i ++ ) {
            if(str.substring(i, i+3).equals("cat")) dcount++;
            if(str.substring(i, i+3).equals("dog")) ccount++;
        }
        return dcount == ccount;
    }
    public static  int countHi(String str) {
        int count = 0;
        for(int i = 0; i < str.length()-1; i ++) {
            if(str.substring(i, i+2).equals("hi"));
            count++;
        }
        return count;
    }

    public static String doubleChar(String str) {
        String s ="";
        for(int i=0; i < str.length(); i++) {
            s+= Character.toString(str.charAt(i)) + Character.toString(str.charAt(i));
        }
        return s;
    }
}
