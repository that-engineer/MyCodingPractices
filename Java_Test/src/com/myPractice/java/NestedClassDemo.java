package com.myPractice.java;

public  class NestedClassDemo {
	private int a;
	
	static class InnerStatic{
		static int i=10;
	}
	class InnerClass{
		private int b;
		
	}
	public static void main(String[] args) {
		System.out.println(InnerStatic.i);
		NestedClassDemo nestedDemo = new NestedClassDemo();
		InnerStatic.i=20;
		InnerStatic innerStaticDemo = new InnerStatic();
		System.out.println(innerStaticDemo.i);
		InnerClass innerDemo = nestedDemo.new InnerClass();
		System.out.println(nestedDemo.a);
		System.out.println(innerDemo.b);
	}

}
