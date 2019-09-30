package com.myPractice.java;

public class CustomHashMapApp {
	public static void main(String[] args) {
		CustomHashMap<Integer, Integer> h = new CustomHashMap<Integer, Integer>();
		h.put(1, 11);
		h.put(2, 22);
		h.put(3, 33);
		
		System.out.println(h.get(2));
	}

}
