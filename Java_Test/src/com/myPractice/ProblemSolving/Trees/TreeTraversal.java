package com.myPractice.ProblemSolving.Trees;

public class TreeTraversal {
	public static void printInOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			printInOrderTraversal(root.left);
			System.out.println(root.data);
			printInOrderTraversal(root.right);
		}
	}
	public static void printPreOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.println(root.data);
			printPreOrderTraversal(root.left);
			printPreOrderTraversal(root.right);
		}
	}
	public static void printPostOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			printPostOrderTraversal(root.left);
			printPostOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	public static void main(String[] dcs) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		printInOrderTraversal(tree.root);
		System.out.println();
		printPreOrderTraversal(tree.root);
		System.out.println();
		printPostOrderTraversal(tree.root);
	}
}
