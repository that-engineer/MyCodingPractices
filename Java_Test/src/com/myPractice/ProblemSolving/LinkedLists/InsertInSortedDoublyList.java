package com.myPractice.ProblemSolving.LinkedLists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertInSortedDoublyList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node) {
		while (node != null) {
			System.out.println(node.data);

			node = node.next;

			if (node != null) {
				System.out.println();
			}
		}
	}

	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode curr = head;
		DoublyLinkedListNode temp = null;
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if (head == null) {
			head = node;
		} else if (head.data > data) {
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			while ((curr.next != null) && (curr.data < data)) {
				curr = curr.next;
			}
			//DoublyLinkedListNode prev = curr.prev;
			/*
			 * if(curr.next==null) {
			 * 
			 * }
			 */
			node.next = curr;
			node.prev = curr.prev;
			curr.prev.next = node;
			curr.prev = node;
		}

		return head;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		DoublyLinkedList llist = new DoublyLinkedList();
		llist.insertNode(1);
		llist.insertNode(2);
		llist.insertNode(3);
		llist.insertNode(8);
		llist.insertNode(10);

		int data = 11;

		DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

		printDoublyLinkedList(llist1);
	}
}
