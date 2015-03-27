package com.elementary.algorithm.tree;

public class ThreadBinaryTreeOperator {

	//use pre order input character constructor a binary tree;
	public ThreadBinaryTree<Character> constructorBinaryTree(){
		index=0;
		ThreadBinaryTree<Character> root=null;
		root=constructor(root);
		preorderTraverse(root);
		return inorderTraverseThreading(root);
	}
	//use preorder traverse to validate the tree's structure;
	private void preorderTraverse(ThreadBinaryTree<Character> node){
		if(node!=null){
			visitNode(node);
			preorderTraverse(node.leftChild);
			preorderTraverse(node.rightChild);
		}
	}
	//construct the threading binary tree, complete the leaf node's thread;
	private ThreadBinaryTree<Character> pre;
	private ThreadBinaryTree<Character> inorderTraverseThreading(ThreadBinaryTree<Character> root){
		ThreadBinaryTree<Character> head=new ThreadBinaryTree<Character>();
		head.data='@';
		head.leftBranch=BranchType.LINE;
		head.leftChild=root;
		head.rightBranch=BranchType.THREAD;
		head.rightChild=head;
		pre=head;
		threading(root);
		head.rightChild=pre;
		return head;
	}
	private void threading(ThreadBinaryTree<Character> node){
		if(node!=null){
			threading(node.leftChild);
			if(node.leftChild==null){
				node.leftBranch=BranchType.THREAD;
				node.leftChild=pre;
			}
			if(pre.rightChild==null){
				pre.rightBranch=BranchType.THREAD;
				pre.rightChild=node;	
			}
			pre=node;
			threading(node.rightChild);
		}
	}
	private void visitNode(ThreadBinaryTree<Character> node){
		System.out.print(node.data);
	}
	private int index=0;
	private char getNodeData(int index){
		final char[] dataArray={'A','B','C','@','@','D','E','@','G','@','@','F','@','@','@'};
		char data=dataArray[index]; 
		return data;
	}
	//constructor ThreadBinaryTree basic branch;
	private ThreadBinaryTree<Character> constructor(ThreadBinaryTree<Character> node){
		char data=getNodeData(index++);
		if(data!='@'){
			node =new ThreadBinaryTree<Character>();
			node.data=data;
			ThreadBinaryTree<Character> child=constructor(node.leftChild);
			node.leftChild=child;
			if(child!=null){
				node.leftBranch=BranchType.LINE;
			}else{
				node.rightBranch=BranchType.THREAD;
			}
			child=constructor(node.rightChild);
			node.rightChild=child;
			if(child!=null){
				node.rightBranch=BranchType.LINE;
			}else{
				node.rightBranch=BranchType.THREAD;
			}
		}
		return node;
	}
	


	public static void main(String[] args) {
		ThreadBinaryTreeOperator operator=new ThreadBinaryTreeOperator(); 
		ThreadBinaryTree<Character> threadBinaryTreeRoot = operator.constructorBinaryTree();
		
	}
}
