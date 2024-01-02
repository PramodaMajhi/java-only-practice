package com.gfg.Strings;

public class Chessboard {
    public String squareIsWhite(String a) {
        if(a.length() > 2)
            return "Error";
            String color = "";

            if(a.charAt(0) % 2 != a.charAt(1) % 2){
                color = "White";
            }
            else {
                color = "Black";
            }
            return color;
        }

    public static void main(String[] args) {
        Chessboard test = new Chessboard();
        String s =  test.squareIsWhite("f71");
        System.out.println(s);
    }

    /*
    Repeat question:

     */
}
