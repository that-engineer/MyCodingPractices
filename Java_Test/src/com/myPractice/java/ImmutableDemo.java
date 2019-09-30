package com.myPractice.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class ImmutableDemo implements Cloneable {
	
	 final int id;
	 final List ll;
	 final HashMap m;
	
	public ImmutableDemo(int id, List<Integer> ll,HashMap m) {
		this.id = id;
		this.ll = ll;
		this.m = m;
	}
	
	public int getId() {
		return id;
	}

	public List<Integer> getLl() {
		return Collections.unmodifiableList(ll);
		//return ll.asList();
	}
	
	public HashMap getM() {
		return (HashMap<String, String>)m.clone();
	}

	public static void main(String[] sd) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);al.add(2);al.add(3);al.add(4);
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		ImmutableDemo d= new ImmutableDemo(10,al,h1);
		al.add(5);
		List<Integer> l1 = d.getLl();
		for(Integer i:l1)
		System.out.println(i);
		//l1.add(6);
		
	}
}
