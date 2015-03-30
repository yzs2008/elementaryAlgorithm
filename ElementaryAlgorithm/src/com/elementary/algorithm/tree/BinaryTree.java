package com.elementary.algorithm.tree;

/**
 *  
 * @author kaidi
 *
 */
public class BinaryTree<T> {
	T data;
	BinaryTree<T> leftChild;
	BinaryTree<T> rightChild;
	
	public BinaryTree(){
		
	}

	public BinaryTree(T data){
		this.data=data;
	}
	
	public BinaryTree(T data, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}



	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}



	public void setLeftChild(BinaryTree<T> leftChild) {
		this.leftChild = leftChild;
	}



	public BinaryTree<T> getRightChild() {
		return rightChild;
	}



	public void setRightChild(BinaryTree<T> rightChild) {
		this.rightChild = rightChild;
	}



}
