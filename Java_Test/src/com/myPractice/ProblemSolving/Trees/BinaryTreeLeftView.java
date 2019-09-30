package com.myPractice.ProblemSolving.Trees;

public class BinaryTreeLeftView {
	public static void printTreeLeftView(Node root) {
		
	}
	public static void main(String[] sdf) { 
	 BinaryTree tree = new BinaryTree(1);
	 tree.root.left=new Node(2);
	 tree.root.right=new Node(3);
	 tree.root.left.right=new Node(4);
	 tree.root.left.right.right=new Node(5);
	 tree.root.left.right.right.right=new Node(6);
	 tree.root.left.right.right.right.right=new Node(7);
	 
	 printTreeLeftView(tree.root);
	 
 }
}
