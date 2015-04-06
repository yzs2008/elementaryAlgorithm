package com.elementary.algorithm.sort;


import com.elementary.algorithm.linkedlist.DoubleLinkedList;


/**
 * 直接插入排序
 * @author yzs
 *
 */
public class InsertSort {

	int[] data={49,38,65,97,76,13,27,49};
	DoubleLinkedList<Integer> linkedListData;
	TableNode<Integer>[] table;
	public InsertSort(){
		init();
		initTable();
	}
	//表插入排序后的调整
	private void tableArrange(){
		int curArrange=table[0].next;
		int next=0;
		for(int i=1;i<table.length;i++){
			while(curArrange<i){//小于说明原来此处的元素已经被移动到其它地方，具体位置是next中指示着
				curArrange=table[curArrange].next;
			}
			next=table[curArrange].next;//下一个元素的位置
			TableNode<Integer> tem=table[i];
			table[i]=table[curArrange];
			table[curArrange]=tem;
			table[i].next=curArrange;//防止链表断裂
			curArrange=next; 
		}
	}
	//表插入排序
	public void tableInsertSort(){
		//构建初始循环链
		table[0].next=1;
		table[1].next=0;
		for(int i=2;i<table.length;i++){
			int cur=table[i].value;//当前插入值
			TableNode<Integer> pointer=table[0];
			while(cur>table[pointer.next].value){
				pointer=table[pointer.next];
			}
			table[i].next=pointer.next;
			pointer.next=i;
		}
		showTableBeforeArrange();	
		tableArrange();
		showTableAfterArrange();
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
	//折半插入排序：针对顺序数组存储结构
	public void binaryInsertSort(){
		for(int i=1;i<data.length;i++){
			int cur=data[i];
			
			int low=0;
			int high=i-1;
			int mid=0;
			while(low<=high){
				mid=(low+high)/2;
				if(data[mid]<cur){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
			//high 指示在正确插入位置之前
			//插入在high+1
			for(int j=i;j>high+1;j--){
				data[j]=data[j-1];
			}
			data[high+1]=cur;
		}
		showResult();
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
	private void showTableBeforeArrange(){
		TableNode<Integer> pointer=table[table[0].next];
		System.out.println("table sort result is:");
		while(pointer.value!=table[0].value){
			int tem=pointer.value;
			pointer=table[pointer.next];
			System.out.print(tem+" ");
		}
		System.out.println();
	}
	private void showTableAfterArrange(){
		System.out.println("after arrange, visit by sequence:");
		for(int i=1;i<table.length;i++){
			System.out.print(table[i].value+" ");
		}
		System.out.println();
	}
	private void showDoubleLinkedList(DoubleLinkedList<Integer> head){
		System.out.println("double linked list is:");
		DoubleLinkedList<Integer> pointer=head.next;
		while(pointer!=null){
			System.out.print(pointer.data+" ");
			pointer=pointer.next;
		}
		System.out.println();
	}
	private void showResult(){
		System.out.print("result is:");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
	//构建需要进行表排序的数据集
	private void initTable(){
		//cannot create a generic array of TableNode<Integer> why?
		table=new TableNode[9];
		table[0]=new TableNode<Integer>(Integer.MAX_VALUE);
		table[1]=new TableNode<Integer>(49);
		table[2]=new TableNode<Integer>(38);
		table[3]=new TableNode<Integer>(65);
		table[4]=new TableNode<Integer>(97);
		table[5]=new TableNode<Integer>(76);
		table[6]=new TableNode<Integer>(13);
		table[7]=new TableNode<Integer>(27);
		table[8]=new TableNode<Integer>(49);
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
	public static void main(String[] args){
		InsertSort insertSort=new InsertSort();
		insertSort.showResult(); 
//		insertSort.directInsertSort();
//		insertSort.directInsertSort4LinkedList();
		insertSort.binaryInsertSort();
		insertSort.tableInsertSort();
		
	}
}
