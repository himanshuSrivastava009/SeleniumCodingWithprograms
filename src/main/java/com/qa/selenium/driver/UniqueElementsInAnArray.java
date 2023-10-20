package com.qa.selenium.driver;

public class UniqueElementsInAnArray {

    public static void main(String[] args) {

        int[] arr = {5,5,7,3,8,9,23,6};
        int count = 1;
        int uniqueCount = 0;
        int minvalue = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){

            if(arr[i]==arr[i+1]){

                count++;
            }
            else {
                if(count ==1) {
                    System.out.println(arr[i] + "  " + count);
                  //  System.out.println(arr[arr.length-1]+ "  " +count);
                    if(arr[i]<minvalue){
                        minvalue = arr[i];
                    }
                    uniqueCount++;
                }
                count = 1;


            }
        }
       // System.out.println("Number of Unique Elements are " +uniqueCount);

        if(count==1){

            System.out.println(arr[arr.length-1]+ "  " +count);
            if(arr[arr.length-1]<minvalue){
                minvalue=arr[arr.length -1];
            }
            uniqueCount++;
        }
        System.out.println("Number of Unique Elements are " +uniqueCount);
        System.out.println("Smallest unique value is " +minvalue);
    }
}
