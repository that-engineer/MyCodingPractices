package com.myPractice.ProblemSolving;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		String s = "abcba";
		isStringPalindrome(s);
		isStringPalindromeUsingStack(s);
	}

	private static void isStringPalindromeUsingStack(String s) {
		Stack st = new Stack();
	}

	private static void isStringPalindrome(String s) {
		char[] arr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1;i>=0;i--) {
			sb.append(arr[i]);
		}
		System.out.println(s.equals(sb.toString()));
	}

}
