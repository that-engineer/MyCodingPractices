package com.myPractice.ProblemSolving.LinkedLists;

public class LinkedList {
	public Node head;
	
	public class Node {
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
		
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next=head;
		head = node;
	}
	
	public void insertAfter(Node prev, int data) {
		if(prev==null) {
			System.out.println("The node after which data is to be inserted can't be null ");
			return;
		}
		Node newNode = new Node(data);
		newNode.next=prev.next;
		prev.next = newNode;
	}
	public void append(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node currNode = head;
		while(currNode.next != null) {
			currNode=currNode.next;
		}
		
		currNode.next=newNode;
		return;
	}
	public void printList() {
		Node curr = head;
		if(curr==null) {
			System.out.println("List is empty");
		}
		while(curr!=null) {
			System.out.println(curr.value);
			curr=curr.next;
		}
	}
}
