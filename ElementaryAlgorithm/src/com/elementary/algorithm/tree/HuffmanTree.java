package com.elementary.algorithm.tree;

/**
 * 赫夫曼树
 * @author yzs
 *
 */
public class HuffmanTree<T> {
	T data;
	HuffmanTree<T> leftChild;
	HuffmanTree<T> rightChild;
	HuffmanTree<T> parent;
	Integer weight;
	
	public HuffmanTree(){
		
	}
	public HuffmanTree(T data){
		this.data=data;
		weight=1;
	}
	public HuffmanTree(T data,Integer weight){
		this.data=data;
		this.weight=weight;
	}
}
