package com.qa.selenium.driver;

public class LargestvalueInAnArray {

    public static void main(String[] args) {

        int[] ar = {3,4,5,-1,2,-6,10,56,90,7,90};
        int maxvalue = Integer.MIN_VALUE;
        int maxindex = 0;
        for(int i=0;i<ar.length;i++){

            if(ar[i]>=maxvalue){

                maxvalue = ar[i];
                maxindex = i;
            }
        }
        System.out.println("maximum Value == " +maxvalue);
        System.out.println("maximum Index of max value == " +maxindex);
    }
}
