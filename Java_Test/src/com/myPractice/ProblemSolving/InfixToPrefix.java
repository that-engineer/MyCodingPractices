package com.myPractice.ProblemSolving;

import java.util.Stack;

public class InfixToPrefix {
	public static String infixToPrefix(String s) {
		Stack<Character> operators = new Stack<Character>();
		Stack<Character> operands = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				
			}
		}
		return "";
	}

	public static void main(String[] args) {
		String s = "5+(6*4)-1";
		System.out.println(infixToPrefix(s));

	}

}
