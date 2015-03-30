package com.elementary.algorithm.tree;

/**
 * save a tree use double link, the first link connected with the node's first child.
 * the next link connected with the node's closed sibling.
 * @author kaidi
 *
 */
public class TreeSiblingChild<T> {
	T data;
	TreeSiblingChild<T> firstChild;
	TreeSiblingChild<T> closedSibling;
	
	public TreeSiblingChild(){
		
	}

	public TreeSiblingChild(T data){
		this.data=data;
	}
}
