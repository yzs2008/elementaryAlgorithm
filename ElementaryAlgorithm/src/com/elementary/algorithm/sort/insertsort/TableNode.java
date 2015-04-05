package com.elementary.algorithm.sort.insertsort;

/**
 * 直接排序中的表排序数据结构
 * @author yzs
 *
 * @param <T>
 */
public class TableNode<T> {
	public T value;
	public Integer next;
	public TableNode(){
		
	}
	public TableNode(T value){
		this.value=value;
	}
}
