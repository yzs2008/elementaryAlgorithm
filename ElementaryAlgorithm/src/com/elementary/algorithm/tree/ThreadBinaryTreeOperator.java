package com.elementary.algorithm.tree;

public class ThreadBinaryTreeOperator {

	//use pre order input character constructor a binary tree;
	public void constructorBinaryTree(){
		index=0;
		ThreadBinaryTree<Character> root=null;
		root=constructor(root);
		preorderTraverse(root);
	}
	private void preorderTraverse(ThreadBinaryTree<Character> node){
		if(node!=null){
			visitNode(node);
			preorderTraverse(node.leftChild);
			preorderTraverse(node.rightChild);
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
	private ThreadBinaryTree<Character> constructor(ThreadBinaryTree<Character> node){
		char data=getNodeData(index++);
		if(data!='@'){
			node =new ThreadBinaryTree<Character>();
			node.data=data;
			node.leftChild=constructor(node.leftChild);
			node.rightChild=constructor(node.rightChild);
		}
		return node;
	}
	


	public static void main(String[] args) {
		ThreadBinaryTreeOperator operator=new ThreadBinaryTreeOperator(); 
		operator.constructorBinaryTree();
	}
}
