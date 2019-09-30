package com.myPractice.ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class ConvertToAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        int sum=0;
        for(int i=0;i<a.length();i++){
        	countA[a.charAt(i)-'a']++;
        }
        for(int j=0;j<b.length();j++){
            int index = b.charAt(j)-'a';
            if(countA[index]>0){
                 countA[index]--;
            }else{
                countB[index]++;
            }
           
        }
        for(int i=0;i<26;i++){
        	//System.out.print(count[i]+" ");
            sum=sum+countA[i]+countB[i];
        }
        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.in));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        System.out.println(makeAnagram(a, b));
        
        scanner.close();
    }
}
