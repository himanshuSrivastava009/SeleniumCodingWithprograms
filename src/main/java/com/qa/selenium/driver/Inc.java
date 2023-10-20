package com.qa.selenium.driver;

public class Inc {
  // static
    public static void main(String[] args) {

        int x = 5;
        System.out.println(x++ );
        System.out.println(x );

        String str1 = "hello";
        String str2 = "world";

        String str3 = str1+str2;
       String str4 = str3;
        System.out.println(str4==str3);
    }
}
