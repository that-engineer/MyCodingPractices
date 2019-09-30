package com.myPractice.ProblemSolving.LinkedLists;

public class MergeTwoLinkedList {

	static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
	public static void printDoublyLinkedList(SinglyLinkedListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;

			if (node != null) {
				System.out.println();
			}
		}
	}

	// Complete the sortedInsert function below.

	/*
	 * For your reference:
	 *
	 * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
	 * DoublyLinkedListNode prev; }
	 *
	 */
	static SinglyLinkedListNode mergeLinkedList(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int a, int b) {
		SinglyLinkedListNode ptr1 = head1;
		SinglyLinkedListNode ptr2= head1;
		SinglyLinkedListNode curr1= head1;
		SinglyLinkedListNode curr2 = head2;
		while(a>0 || b>0) {
			if(a==0) {
				ptr1=curr1;
			}
			ptr2=curr1;
			curr1= curr1.next;
			a--;
			b--;
		}
		ptr1.next=head2;
		while(curr2.next!=null) { 
			curr2 = curr2.next;
		}
		curr2.next=ptr2;
		return head1;
	}

	public static void main(String[] args) {

		SinglyLinkedList llist1 = new SinglyLinkedList();
		llist1.insertNode(1);
		llist1.insertNode(2);
		llist1.insertNode(3);
		llist1.insertNode(4);
		llist1.insertNode(5);

		SinglyLinkedList llist2 = new SinglyLinkedList();
		llist2.insertNode(6);
		llist2.insertNode(7);
		llist2.insertNode(8);
		llist2.insertNode(9);
		llist2.insertNode(10);

		SinglyLinkedListNode llist = mergeLinkedList(llist1.head, llist2.head, 2, 4);
		printDoublyLinkedList(llist1.head);

	}
}
