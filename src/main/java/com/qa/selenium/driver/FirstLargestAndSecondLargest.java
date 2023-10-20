package com.qa.selenium.driver;

public class FirstLargestAndSecondLargest {

    public static void main(String[] args) {

        int[] ar = {3,5,7,2,9,8,10,0,8,7};
        int p=Integer.MIN_VALUE,vp=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            if(ar[i]>p){
                vp=p;
                p=ar[i];
            } else if (ar[i]>vp) {
                vp=ar[i];
            }
        }

        System.out.println("largestnumber == " +p +" SecondLargestNumber == " +vp);
    }
}
