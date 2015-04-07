package com.elementary.algorithm.collection;

import java.util.List;
import java.util.ArrayList;

/**
 * 求子集
 * @author kaidi
 *
 */
public class Subset {

	int[] collection={1,2,3};
	List<List<Integer>> subsetList=new ArrayList<List<Integer>>();
			
	public void getSubset(int index,List<Integer> subset){
		if(index>=collection.length){
			List<Integer> oneSubset=new ArrayList<Integer>();
			for(int i:subset){
				oneSubset.add(i);
			}
			subsetList.add(oneSubset);
		}else{
			subset.add(collection[index]);// 包含该元素
			getSubset(index + 1, subset);
			subset.remove(subset.indexOf(collection[index]));// 不包含该元素
			getSubset(index + 1, subset);
		}
	}
	private void showResult(){
		int k=0;
		System.out.println(collection.toString()+"子集是：");
		for(List<Integer> list:subsetList){
			System.out.print(++k+":{");
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Subset ss=new Subset();
		ss.getSubset(0,new ArrayList<Integer>());
		ss.showResult();
	}

}
