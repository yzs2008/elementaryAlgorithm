/**
 * 
 */
package com.elementary.algorithm.collection;

/**
 * @author yzs
 *
 */
public class Permutation {

	/**
	 * 【名称】计算集合的全排列
	 * 【说明】 集合长度只有1，其全排列为自身	{a}-->a
	 * 集合长度为2，{a,b}-->ab;ba;理解为集合内第一个元素a开头，集合内其它元素{b}的全排列；集合
	 * 内第二个元素b开头，其它元素 {a}的全排列集合；
	 * 
	 * @param collection 集合
	 * @param curIndex 当前取集合的第几个元素作为开头,0是第一个元素
	 * @param theN 集合内元素个数,1个或N个
	 */
	public void permutation(int[] collection,int curIndex,int theN){
		if(curIndex==theN){
			//当前集合内只有一个元素，它的全排列为自身
			show(collection);
			return;
		}else{
			for(int k=curIndex;k<theN;k++){
				//C={A,B,C}
				int tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
				//C={B,A,C}
				permutation(collection,curIndex+1,theN);//{B}U{A,C}
				
				//复原，用来计算下一个差集
				tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
			}
		}
	}
	private void show(int[] collection){
		System.out.println();
		for(int i:collection){
			System.out.print(i);
		}
	}
	
	public static void main(String[] args) {
		int[] collection={1,2,3,4};
		Permutation permutation=new Permutation();
		permutation.permutation(collection, 0, 4);
	}

}
