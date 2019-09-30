package com.myPractice.java;

import com.myPractice.ProblemSolving.LinkedLists.LinkedList;

public class ListTest {

	public static void main(String[] args) {
	LinkedList l1 = new LinkedList();
	
	l1.push(1);
	l1.push(2);
	l1.push(3);
	System.out.println(l1.head.value);
	l1.printList();

	}

}
