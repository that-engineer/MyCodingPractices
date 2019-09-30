package com.myPractice.java;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        char[] str = s.nextLine().toCharArray();  
        int[] arr = new int[str.length];
		/*
		 * for(int i=0;i<str.length;i++){ arr[i]= Integer.parseInt(str[i]); }
		 */
        System.out.println(str.length);
        if((str.length)%2!=0){
            System.out.println("false");
        }else{
            int count1=0,count2=0;
            for(int i=0;i<str.length;i++){
                if(str[i]==0){
                    count1++;
                }
                if(str[i]==1){
                    count2++;
                }
            }
            if(count1==count2){
                System.out.println("true"); 
            }
        }
        
    }
}

