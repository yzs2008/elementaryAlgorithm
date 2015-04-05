package com.elementary.algorithm.linkedlist;

/**
 * 双链表
 * @author yzs
 *
 */
public class DoubleLinkedList<T> {
	public T data;
	public DoubleLinkedList<T> pre;
	public DoubleLinkedList<T> next;
	public DoubleLinkedList() {
	}
	public DoubleLinkedList(T data){
		this.data=data;
	}
}
