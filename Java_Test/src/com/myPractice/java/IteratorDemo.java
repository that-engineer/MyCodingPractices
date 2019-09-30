package com.myPractice.java;

import java.util.*;
import java.util.ListIterator;
import java.util.Vector;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;

public class IteratorDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Vector v = new Vector();
		list.add(7);list.add(2);list.add(4);list.add(8);
		v.add("asd");v.add("sab");v.add("wasa");v.add("esd");
		
		Enumeration e = v.elements();
		Enumeration e1= Collections.enumeration(list);
		ListIterator l = list.listIterator();
		ArrayList al = new ArrayList();
		al.add(1);
		al.remove(0);
		list.remove();
		HashSet hs = new HashSet();
		hs.add("dasd");
		hs.add(23);
		hs.remove(23);
		TreeSet s = new TreeSet();
		

	}

}
