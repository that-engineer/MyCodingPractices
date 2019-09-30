package com.myPractice.java;

import java.util.HashMap;
import java.util.Map;

class Result {

	public static String betterCompression(String s) {
		// Write your code here
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char key = ' ';
		char c = ' ';
		Integer value = 0, pValue = 0;
		boolean nc = false, present = false;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				key = c;
				value = 0;
				nc = true;
				if (map.get(c) != null) {
					pValue = (Integer) map.get(c);
					present = true;
				} else {
					present = false;
				}
			} else {
				if (nc) {
					value = Character.getNumericValue(c);
					nc = false;
				} else {
					value = 10 * value + Character.getNumericValue(c);
				}
			}
			if (present) {
				map.put(key, pValue + value);
			} else {
				map.put(key, value);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

	public static void main(String[] as) {
		System.out.println(betterCompression("a12c10c2b56c10"));
	}
}
