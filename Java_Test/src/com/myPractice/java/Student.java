package com.myPractice.java;

public class Student {
	 String name;

	public Student(String name) {
		super();
		this.name = name;
	}
	public boolean equals(Object obj) {
		Employee e =(Employee)obj;
		char[] arr1 = this.name.toCharArray();
		char[] arr2 = e.name.toCharArray();
		
		if(arr1.length==arr2.length) {
			for(int i=0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return true;
				}
			}
				return false;
		}else {
			return true;
		}
		
	}

}
