package com.elementary.algorithm.sort;


/**
 * 选择排序
 * @author yzs
 *
 */
public class SelectSort {

	int[] data={49,38,65,97,76,13,27,49};
	
	//简单直接选择排序，适用于少元素，而且需要稳定排序算法的情况
	public void simpleSelectSort(){
		int length=data.length;
		for(int i=0;i<length;i++){
			int cur=data[i];
			int curIndex=i;
			for(int j=i+1;j<length;j++){
				if(data[j]<cur){//找到最小值
					cur=data[j];
					curIndex=j;//保存最小值的索引位置
				}
			}
			data[curIndex]=data[i];
			data[i]=cur;
		}
		showResult();
	}
	private void showResult(){
		System.out.print("the data is :{");
		for(int i:data){
			System.out.print(i+" ");
		}
		System.out.print("}");
		System.out.println();
	}
	public static void main(String[] args){
		SelectSort ss=new SelectSort();
		ss.showResult();
		ss.simpleSelectSort();
	}
}
