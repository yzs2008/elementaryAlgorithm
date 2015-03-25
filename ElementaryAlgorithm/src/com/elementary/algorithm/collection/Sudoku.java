/**
 * 
 */
package com.elementary.algorithm.collection;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yzs
 * 九宫格游戏
 * 通过对1-9的全排列，然后计算每一种符合九宫格的排列，找出所有九宫格组合
 */
public class Sudoku {

	private List<int[]> gridList;//九宫格组合集合
	public Sudoku(){
		gridList=new ArrayList<int[]>();
	}
	
	public void findGrid(){
		int[] collection={1,2,3,4,5,6,7,8,9};
		gridList.clear();
		permutation(collection,0,9);
		showGrids();
	}
	private void permutation(int[] collection,int curIndex,int theN){
		if(curIndex==theN){
			if(isGrid9(collection)){
				gridList.add(collection);
			}
			return;
		}else{
			for(int k=curIndex;k<theN;k++){
				int tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
				
				permutation(collection,curIndex+1,theN);
				
				tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
			}
		}
	}
	private boolean isGrid9(int[] collection){
		boolean yes=true;
		int total=15;
		int sum=0;//验证行的和是否等于15
		for(int i=0;i<9;i++){
			sum+=collection[i];
			if((i+1)%3==0){
				if(sum!=total){
					return !yes;
				}
				sum=0;
			}
		}
		sum=0;//验证列的和是否等于15
		for(int col=0,row=0;col<9;col++,row+=3){
			row=row+1-1;
			sum+=collection[row];
			if((col+1)%3==0){
				if(sum!=total){
					return !yes;
				}
				sum=0;
				row=(col+1)/3-3;
			}
		}
		//验证对角线之和是否等于15
		sum=collection[0]+collection[4]+collection[8];
		if(sum!=total){
			return !yes;
		}
		sum=collection[2]+collection[4]+collection[6];
		if(sum!=total){
			return !yes;
		}
		return yes;
	}
	public void showGrids(){
		for(int i=0;i<gridList.size();i++){
			System.out.println("****************************"+i);
			int[] grid=gridList.get(i);
			for(int j=0;j<grid.length;j++){
				if(j%3==0){
					System.out.println();
				}
				System.out.print(grid[j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Sudoku sudoku=new Sudoku();
		//sudoku.isGrid9(new int[]{1, 5, 9, 6, 2, 7, 8, 4, 3});
		sudoku.findGrid();

	}

}
