package com.arrays.practiceproblem;

import java.beans.PropertyEditorSupport;
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
       // System.out.println(sameStarChar("*xa*az"));
       // System.out.println(oneTwo("abc"));
       // System.out.println(zipZap("zipXzap"));
       // System.out.println(sum67(new int[] {1, 2, 2, 6, 99, 99, 7}));
       // System.out.println(starOut("ab*cd"));
       // System.out.println(plusOut("12xy34", "xy"));
       // System.out.println(wordEnds("abcXY123XYijk", "XY"));
       // System.out.println(countYZ("fez day"));
       // System.out.println(toLowerCase("Hello"));
       //   System.out.println(withoutString("Hello there", "e"));
        System.out.println(equalIsNot("isisnotno7Not"));

    }
/*
equalIsNot("This is not") → false
equalIsNot("This is notnot") → true
equalIsNot("noisxxnotyynotxisi") → true
 */
    public static boolean equalIsNot(String str) {
        int isCount = 0 , notCount = 0;
        for (int i = 0; i < str.length() ; i++) {
            if(i+2<=str.length()  && str.substring(i, i+2).equals("is")){
                isCount++;
            } else if(i+3<=str.length()  && str.substring(i, i+3).equals("not")){
                notCount++;
            }
        }
        return isCount == notCount ;
    }
    /*
    withoutString("Hello there", "llo") → "He there"
    withoutString("Hello there", "e") → "Hllo thr"
    withoutString("Hello there", "x") → "Hello there"
    */
    public static  String withoutString(String base, String remove) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < base.length(); i++) {
                if((i<= base.length() - remove.length())
               && base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) {
                   i+=remove.length() - 1;
                }else {
                    sb.append(base.charAt(i));
                }
        }
      return sb.toString();
    }
    /*
    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2
     */
    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char c[] = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++) {
            if(Character.isUpperCase(c[i])) {
                char ch = (char)( c[i] - 'A' + 'a');
                sb.append(ch);
            } else {
            sb.append(c[i]);}
        }
        return sb.toString();
    }
    public static int countYZ(String str) {
        String[] arr = str.split(" ");
        int count = 0;
        for(String s: arr) {
            if(s.endsWith("y") || s.endsWith("z")) count++;
        }

        return count;
    }
    /**
     wordEnds("abcXY123XYijk", "XY") → "c13i"
     wordEnds("XY123XY", "XY") → "13"
     wordEnds("XY1XY", "XY") → "11"
     */
    public static String  wordEnds(String str, String word) {
        StringBuilder sb = new StringBuilder();
        int i =0;
        if(str.length() >= word.length() + 1 &&
                str.substring(0, word.length()).equals(word)) {
            i = word.length() - 1;
            sb.append(str.charAt(i + 1));
        }
        while(i < str.length() - word.length()) {
            if(str.substring(i + 1, i + 1 + word.length()).equals(word)) {
                sb.append(str.charAt(i));
                i = i + word.length();
                if(i < str.length() - 1) {
                    sb.append(str.charAt(i + 1));
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * plusOut("12xy34", "xy") → "++xy++"
     * plusOut("12xy34", "1") → "1+++++"
     * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
     * @param str
     * @param word
     * @return
     */
    public static String plusOut(String str, String word) {
        StringBuilder sb = new StringBuilder();
        int i =0;
        while (i < str.length()) {
            if(i <= str.length() - word.length() &&
                    str.substring(i, i+word.length()).equals(word)) {
                sb.append(word);
                i+= word.length();
            }
            else {
                sb.append("+");
                i++;
            }
        }
       return sb.toString();
    }

    /**
     * starOut("ab*cd") → "ad"
     * starOut("ab**cd") → "ad"
     * starOut("sm*eilly") → "silly"
     * @param str
     * @return
     */
    public static String starOut(String str) {
        String out = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || (i > 0 && str.charAt(i-1) == '*')) continue;
            if (i < str.length()-1 && str.charAt(i+1) == '*') continue;

            out = out + str.charAt(i);
        }

        return out;
    }

    public static int sum67(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == 6) {
                for (int j = i; j < nums.length; j++) {
                      if(nums[j] == 7) {
                          i = j;
                          break;
                      }
                }
            }else {
            sum+=nums[i];
            }
        }
        return sum;
    }

    /**
     * zipZap("zipXzap") → "zpXzp"
     * zipZap("zopzop") → "zpzp"
     * zipZap("zzzopzop") → "zzzpzp"
     * @param str
     * @return
     */
    public static String zipZap(String str) {
       StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length() -2; i++) {
            if(sb.charAt(i) == 'z' && sb.charAt(i+2) == 'p') {
                sb.deleteCharAt(i+1);
            }
        }
        return sb.toString();
    }
    /*
    oneTwo("abc") → "bca"
    oneTwo("tca") → "cat"
    oneTwo("tcagdo") → "catdog"
     */
    public static String oneTwo(String str) {
        String temp = "";
        for (int i = 0; i < str.length() -2 ; i+=3) {
             temp =  temp+str.substring(i+1,i+3)+str.charAt(i);
        }
        return temp;
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
