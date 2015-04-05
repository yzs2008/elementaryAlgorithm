package com.elementary.algorithm.sort.insertsort;

import com.elementary.algorithm.linkedlist.DoubleLinkedList;


/**
 * 直接插入排序
 * @author yzs
 *
 */
public class InsertSort {

	int[] data={49,38,65,97,76,13,27,49};
	DoubleLinkedList<Integer> linkedListData;
	public InsertSort(){
		init();
	}
	private void init(){
		linkedListData=new DoubleLinkedList<Integer>(Integer.MIN_VALUE);
		DoubleLinkedList<Integer> node49_=new DoubleLinkedList<Integer>(49);
		DoubleLinkedList<Integer> node38=new DoubleLinkedList<Integer>(38);
		DoubleLinkedList<Integer> node65=new DoubleLinkedList<Integer>(65);
		DoubleLinkedList<Integer> node97=new DoubleLinkedList<Integer>(97);
		DoubleLinkedList<Integer> node76=new DoubleLinkedList<Integer>(76);
		DoubleLinkedList<Integer> node13=new DoubleLinkedList<Integer>(13);
		DoubleLinkedList<Integer> node27=new DoubleLinkedList<Integer>(27);
		DoubleLinkedList<Integer> node49=new DoubleLinkedList<Integer>(49);
		//向后链
		linkedListData.next=node49_;
		node49_.next=node38; 
		node38.next=node65;
		node65.next=node97;
		node97.next=node76;
		node76.next=node13;
		node13.next=node27;
		node27.next=node49;
		//向前链
		node49.pre=node27;
		node27.pre=node13;
		node13.pre=node76;
		node76.pre=node97;
		node97.pre=node65;
		node65.pre=node38;
		node38.pre=node49_;
		node49_.pre=linkedListData;
	}
	//直接插入排序：针对双链表式存储结构
	//双链表是先删除一个节点，然后再对该节点进行双链表的插入操作 
	public void directInsertSort4LinkedList(){
		DoubleLinkedList<Integer> cur=linkedListData.next;//当前插入节点
		DoubleLinkedList<Integer> pointer=linkedListData;//始终指向表尾节点
		DoubleLinkedList<Integer> next;//下一个需要插入的节点
		while(cur!=null){
			pointer=cur.pre;
			next=cur.next;
			if(cur.data<pointer.data){
				//删除节点
				cur.pre.next=cur.next;
				if(cur.next!=null){//非最后一个节点
					cur.next.pre=cur.pre;
				}					
				while (cur.data < pointer.data) {
					pointer = pointer.pre;
				}
				//在pointer之后插入节点
				cur.pre = pointer;
				cur.next = pointer.next;
				pointer.next.pre = cur;
				pointer.next = cur;
			}
			cur=next;
		}
		showDoubleLinkedList(linkedListData);
	}
	//直接插入排序:针对顺序数组存储结构
	public void directInsertSort(){
		for(int i=1;i<data.length;i++){
			int cur=data[i];
			if(cur<data[i-1]){
//				data[i]=data[i-1];
//				int j=i-2;
				//这种写法会多比较一次，但是逻辑会更加清楚
				int j=i-1;
				for(;j>=0;j--){
					if(cur<data[j]){
						data[j+1]=data[j];
					}else{
						data[j+1]=cur;
						break;
					}
				}
				if(j<0){
					data[0]=cur;
				}
			}
		}
		showResult();
	}
	private void showDoubleLinkedList(DoubleLinkedList<Integer> head){
		System.out.println("double linked list is:");
		DoubleLinkedList<Integer> pointer=head.next;
		while(pointer!=null){
			System.out.print(pointer.data+" ");
			pointer=pointer.next;
		}
	}
	private void showResult(){
		System.out.print("result is:");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		InsertSort insertSort=new InsertSort();
		insertSort.showResult(); 
		insertSort.directInsertSort();
		insertSort.directInsertSort4LinkedList();
	}
}
