package com.elementary.algorithm.tree;

/**
 *  
 * @author kaidi
 *
 */
public class Tree<T> {
	T data;
	Tree<T> leftChild;
	Tree<T> rightChild;
	
	public Tree(){
		
	}

	public Tree(T data){
		this.data=data;
	}
	
	public Tree(T data, Tree<T> leftChild, Tree<T> rightChild) {
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



	public Tree<T> getLeftChild() {
		return leftChild;
	}



	public void setLeftChild(Tree<T> leftChild) {
		this.leftChild = leftChild;
	}



	public Tree<T> getRightChild() {
		return rightChild;
	}



	public void setRightChild(Tree<T> rightChild) {
		this.rightChild = rightChild;
	}



}
