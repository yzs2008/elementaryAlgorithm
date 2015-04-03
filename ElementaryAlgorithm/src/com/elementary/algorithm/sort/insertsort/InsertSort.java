package com.elementary.algorithm.sort.insertsort;

import com.sun.webkit.ContextMenu.ShowContext;

/**
 * 直接插入排序
 * @author yzs
 *
 */
public class InsertSort {

	int[] data={49,38,65,97,76,13,27,49};
	//直接插入排序
	public void directInsetSort(){
		for(int i=1;i<data.length;i++){
			int cur=data[i];
			if(cur<data[i-1]){
				data[i]=data[i-1];
				int j=i-2;
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
		insertSort.directInsetSort();
	}
}
