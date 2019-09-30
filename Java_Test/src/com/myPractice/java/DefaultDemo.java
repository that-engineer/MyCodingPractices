package com.myPractice.java;

interface A{
	default void show() {
		System.out.println("show of A");
	}
}

interface B{
	default void show() {
		System.out.println("show of B");
	}
}
class Parent{
	public void show() {
		System.out.println("show of Parent class");
	}
}
public class DefaultDemo extends Parent implements A//,B
{

	/*
	 * @Override public void show() { A.super.show();
	 * System.out.println("show of Demo"); }
	 */
	
	public static void main(String[] es) {
		DefaultDemo d = new DefaultDemo();
		d.show();
	}

}
