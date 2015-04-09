package com.elementary.algorithm.sort;

import sun.security.util.Length;

/**
 * 合并排序
 * @author yzs
 *
 */
public class MergingSort {
	int[] data={49,38,65,97,76,13,27,49};
	//对于二路合并排序的小修改，不占用n个存储空间，每一个合并操作，使用的其实是插入操作
	public void binaryMerger(){
		int time=0;//第几趟排序
		int length=data.length;//元素总长度
		int size=power(time);//该趟排序每一个分组内元素个数
		while(size<length){
			for(int i=0;i<length;i+=size*2){
				int leftStart=i;
				int leftEnd=leftStart+size-1;
				leftEnd=leftEnd>length-1?length-1:leftEnd;
				int rightStart=i+size;
				rightStart=rightStart>length-1?length-1:rightStart;
				int rightEnd=rightStart+size-1;
				rightEnd=rightEnd>length-1?length-1:rightEnd;
				mergingWithInsert(leftStart, leftEnd, rightStart, rightEnd);
			}
			time++;
			size=power(time);
		}
		showResult();
	}
	public void showResult(){
		System.out.print("elements are :{");
		for(int i:data ){
			System.out.print(i+" ");
		}
		System.out.print("}");
		System.out.println();
	}
	private int power(int time){
		int power=1;
		for(int i=0;i<time;i++){
			power*=2;
		}
		return power;
	}
	private void mergingWithInsert(int leftStart,int leftEnd,int rightStart,int rightEnd){
		int left=leftStart;
		int right=rightStart;
		while(left<=leftEnd&&right<=rightEnd){
			if(data[left]<=data[right]){
				left++;
			}
			else{
				int tem=data[right];
				for(int i=right;i>left;i--){
					data[i]=data[i-1];
				}
				data[left]=tem;
				right++;
				leftEnd++;//让第二个表长度增加，等于是把右表合并到左表
			}
		}
	}
	
	public static void main(String[] args){
		MergingSort ms=new MergingSort();
		ms.binaryMerger();
	}

}
