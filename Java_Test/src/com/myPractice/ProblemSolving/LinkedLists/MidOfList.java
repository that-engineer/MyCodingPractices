package com.myPractice.ProblemSolving.LinkedLists;

import com.myPractice.ProblemSolving.LinkedLists.LinkedList.Node;

public class MidOfList {
	public static Node getMidOfList(Node head) {
		Node ptr1= head;
		Node ptr2= head;
		while((ptr2!=null)&&(ptr2.next!=null)) {
			ptr1= ptr1.next;
			ptr2= ptr2.next.next;
		}
		return ptr1;
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		//ll.push(2);
		//ll.push(3);
		//ll.push(4);
		//ll.push(1);
		//ll.push(7);
		//ll.printList();
		Node node = getMidOfList(ll.head);
		System.out.println(node==null?"List is empty":node.value);
	}

}
