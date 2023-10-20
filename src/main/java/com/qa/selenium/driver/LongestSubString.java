package com.qa.selenium.driver;


/*
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestSubString {

    public static void main(String[] args) {
        String s = "abcdefghij";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int count =0;

        for (int i = 0; i < s.length(); i++) {
           count = s.indexOf(letters.charAt(i));
           count++;
        }
        System.out.println(count);
    }
}
