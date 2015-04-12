package com.elementary.algorithm.search;

/**
 * 次优静态查找树
 * @author kaidi
 *
 */
public class NearlyOptimalSearch {

	//接收一个有序序列
	char[] dataArray={'A','B','C','D','E','F','G','H','I'};
	int[] weightArray={1,1,2,5,3,4,4,3,5};
	
	//保存次优二叉查找树的根节点
	Node<Character> root=createNearlyOptimalTree(0,weightArray.length-1);
	
	//构建次优二叉查找树
	//start:序列的启始位置>=0;end：序列的终止位置<length
	public Node<Character> createNearlyOptimalTree(int start,int end){
		if(start>end){//某子树为空
			return null;
		}
		if(start==end){//唯一一个元素
			Node<Character> node=new Node<Character>(dataArray[start],weightArray[start]);
			node.index=start;
			return node;
		}
		int[] dw=new int[end-start+1];
		for(int i=start;i<=end;i++){
			int summaryWeightLeft=0;//低子表的所有权重之和
			int summaryWeightRight=0;//高子表的所有权重之和
			for(int j=start;j<i;j++){
				summaryWeightLeft+=weightArray[j];
			}
			for(int j=i+1;j<=end;j++){
				summaryWeightRight+=weightArray[j];
			}
			dw[i-start]=summaryWeightRight-summaryWeightLeft;
			//取正值,也即运算得到绝对值
			if(dw[i-start]<0){
				dw[i-start]=dw[i-start]*-1;
			}
		}
		//查找dw，得到最小的索引值
		int index=getMin(dw);
		//生成节点
		Node<Character> node=new Node<Character>(dataArray[index+start],weightArray[index+start]);
		node.index=index+start;
		node.left=createNearlyOptimalTree(start,index-1+start);//递归左子树
		node.right=createNearlyOptimalTree(index+1+start,end);//递归右子树
		return node;
	}
	
	private int getMin(int[] dw){
		int min=dw[0];
		int index=0;
		for(int i=1;i<dw.length;i++){
			if(min>dw[i]){
				min=dw[i];
				index=i;
			}
		}
		return index;
	}

	//搜索关键字
	public int search(char key,Node<Character> node){
		if(node==null){
			return -1;
		}
		if(node.data==key){
			return  node.index;
		}else if(node.data>key){
			return search(key,node.left);
		}else{
			return search(key,node.right);
		}
	}
	
	public void test(){
		char[] testArray={'A','B','C','D','E','F','G','H','I','W','Z','X'};
		for(char c:testArray){
			int index=search(c,root);
			System.out.println(c+":"+index);
		}
	}
	public static void main(String[] args){
		NearlyOptimalSearch nos=new NearlyOptimalSearch();
		nos.test();
		
	}
	
}
