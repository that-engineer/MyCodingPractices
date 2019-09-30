package com.myPractice.ProblemSolving;

import com.myPractice.ProblemSolving.LinkedLists.LinkedList;
import com.myPractice.ProblemSolving.LinkedLists.LinkedListDemo;
import com.myPractice.ProblemSolving.LinkedLists.LinkedList.Node;

public class PallindromeList {
	public static boolean isPalindrome(Node node) {
		Node ptr = node,fastPtr=node;
		while(fastPtr!=null) {
			ptr=ptr.next;
			fastPtr=fastPtr.next.next;
		}
		ptr.next=LinkedListDemo.reverseList(ptr);
		//		while(ptr)
		return true;
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(2);
		ll.append(1);
		
	}

}
