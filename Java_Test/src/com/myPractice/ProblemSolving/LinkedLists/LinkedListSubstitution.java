package com.myPractice.ProblemSolving.LinkedLists;

import com.myPractice.ProblemSolving.LinkedLists.LinkedList.Node;

public class LinkedListSubstitution {
	public static Node substituteList(Node l1,Node l2,int a,int b) {
		Node currL1 = l1;
		Node curr2 = l2;
		while(currL1!=null) {
			
		}
		return l1;
	}
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		LinkedList l2  = new LinkedList();
		l1.append(1); l2.append(6);
		l1.append(2); l2.append(7);
		l1.append(3); l2.append(8);
		l1.append(4); l2.append(9);
		l1.append(5); l2.append(10);
		Node node=substituteList(l1.head,l2.head,2,4);

	}

}
