package com.myPractice.ProblemSolving.Trees;

class Node{
	int data;
	Node left,right;
	
	public Node(int data){
		this.data=data;
		left=right=null;
	}
}


public class BinaryTree {
	Node root;
	
	BinaryTree(int data){
		root.data=data;
	}
	
	BinaryTree(){
		root=null;
	}
	
	public static void main(String[] sd) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right= new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		System.out.println(tree.root.data);
	}
}
