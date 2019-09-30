package com.myPractice.java;

public class ExceptionDemo {

	public static void main(String[] args) {

		try {
			throw new MyException("Custom Exception");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

class MyException extends Exception{
	String s;
	
	/*
	 * MyException() { super(); }
	 */
	 MyException(String s) {
		super(s);
	}
}
