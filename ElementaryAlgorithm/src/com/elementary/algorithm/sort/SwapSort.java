package com.elementary.algorithm.sort;

/**
 * 交换排序
 * @author yzs
 *
 */
public class SwapSort {
	int[] data={49,38,65,97,76,13,27,49};
	
	//最常用的快速排序
	public void quickSort(int low,int high){
		if(low<high){
			int pivotLoc=partion(low,high);
			quickSort(pivotLoc+1, high);//排序高子集
			quickSort(low, pivotLoc-1);//排序低子集
		}
	}
	private int partion(int low,int high){
		int pivotkey=data[low];
		while(low<high){
			while(low<high && data[high]>=pivotkey){
				high--;
			}
			data[high]=data[low];
			while(low<high && data[low]<=pivotkey){
				low++;
			}
			data[low]=data[high];
		}
		data[low]=pivotkey;
		return low;
	}
	//经典的冒泡排序
	public void bubbleSort(){
		int length=data.length;
		boolean isDone=false;
		for(int i=0;i<length&&!isDone;i++){
			isDone=true;
			for(int j=0;j<length-i-1;j++){
				if(data[j]>data[j+1]){
					int tem=data[j];
					data[j]=data[j+1];
					data[j+1]=tem;
					isDone=false;
				}
			}
		}
		showData("bubble");
	}
	private void showData(String name){
		System.out.println(name+" now data is :");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}	
		System.out.println();
	}
	
	public static void main(String[] args){
		SwapSort swapSort=new SwapSort();
		swapSort.showData("init");
		swapSort.bubbleSort();
		swapSort.quickSort(0, swapSort.data.length-1);
		swapSort.showData("quick");
	}
}
