package com.myPractice.java;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class Test {
	static int a=10;
	public void m(Object o) {
		System.out.println("Object");
	}
	public void m(Thread t) {
		System.out.println("Thread");
	}
	public int ExceptionDemo(){
		try {
			//throw new Exception();
			return 1;
		}catch(Exception e) {
			return 3;
		}finally {
			//return 5;
		}
	}
	public static void main(String[] args) {

		Test t = new Test();
		//System.out.println("static "+Test.a);
		Test.a = 14; //System.out.println("static "+Test.a);
		t.m(null); //The method m(Integer) is ambiguous for the type Test when we have 2 or more methods with Integer,Thread
		// or String ,etc
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<String, Integer>();
		/*
		 * Test t1 = new TestChild(); TestChild tc = (TestChild) t1; Test t2 = new
		 * Test(); TestChild tc2 = (TestChild) t2;
		 */
		HashMap map = new HashMap();
		map.put(1, 1);
		map.put(2, 2);
		HashMap m= new HashMap();
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext()) {
			Integer i = (Integer)itr.next();
			m.put(i, map.get(i));
			
		}
		//System.out.println(m);
		map.put(1,3);
		//System.out.println(m);
		System.out.println(t.ExceptionDemo());
		
		
		}

}

class TestChild extends Test{
	int p;
	
}
