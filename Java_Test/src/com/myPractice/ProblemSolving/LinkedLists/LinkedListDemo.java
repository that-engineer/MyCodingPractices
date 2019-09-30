package com.myPractice.ProblemSolving.LinkedLists;

import com.myPractice.ProblemSolving.LinkedLists.LinkedList.Node;

public class LinkedListDemo {
	
	public static Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		if(head==null) {
			System.out.println("List is empty");
			return null;
		}
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head=prev;
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(2);
		ll.push(3);
		ll.push(2);
		ll.push(1);
		ll.push(7);
		ll.insertAfter(ll.head.next, 4);
		ll.append(9);
		ll.printList();
		ll.head=reverseList(ll.head);
		ll.printList();
	}

}
