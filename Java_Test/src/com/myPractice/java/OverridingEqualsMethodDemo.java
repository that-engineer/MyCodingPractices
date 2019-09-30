package com.myPractice.java;

public class OverridingEqualsMethodDemo {

	public static void main(String[] args) {
		Employee e = new Employee("ABC", 1);
		Student s = new Student("ABC");
		System.out.println(s.name.equals(e.name));
		System.out.println(s.equals(e));
		System.out.println(e.name==s.name);
	}

}
