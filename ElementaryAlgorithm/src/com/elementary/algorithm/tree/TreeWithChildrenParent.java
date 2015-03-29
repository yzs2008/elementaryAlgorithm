package com.elementary.algorithm.tree;

import java.util.LinkedList;

/**
 * 
 * @author yzs
 * 
 * 带有孩子链表，和父节点指向的树行结构
 */
public class TreeWithChildrenParent<T> {
	T data;
	TreeWithChildrenParent<T> parent;//指向父节点
	LinkedList<TreeWithChildrenParent<T>> children; //直接孩子链表
	public TreeWithChildrenParent(){
		
	}
	public TreeWithChildrenParent(T data){
		this.data=data;
	}
}
