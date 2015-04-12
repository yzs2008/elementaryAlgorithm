package com.elementary.algorithm.search;

/**
 * 次优二叉查找树节点类型
 * @author kaidi
 *
 * @param <T>
 */
public class Node<T> {
	T data;//值
	Node<T> left;//左孩子
	Node<T> right;//右孩子
	Node<T> prarent;//父节点
	int weight;//该节点的权重
	int index;//节点在顺序存储表中的位置
	
	public Node(){
		
	}
	public Node(T data){
		this.data=data;
	}
	public Node(T data,int weight){
		this.data=data;
		this.weight=weight;
	}
}
