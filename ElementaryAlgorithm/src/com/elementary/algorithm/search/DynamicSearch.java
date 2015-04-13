package com.elementary.algorithm.search;

/**
 *  动态查找方法
 * @author kaidi
 *
 */
public class DynamicSearch {
	
	Node<Integer> root;
	
	//二叉排序树，插入式构建
	public void insertBinarySortTree(Node<Integer> node,int key){
		if(node==null){//二叉树为空
			node=new Node<Integer>(key);
			root=node;
			return;
		}
		if(node.data==key){//查找成功
			System.out.println("查找成功：key="+key);
		}else if(node.data<key){//node小于该关键字
			if(node.right!=null){//查询右子树
				insertBinarySortTree(node.right,key);
			}else{//不存在该节点，加入二叉树中
				Node<Integer> tem=new Node<Integer>(key);
				tem.prarent=node;
				node.right=tem;
			}
		}else{//node 大于该关键字，查询左子树
			if(node.left!=null){
				insertBinarySortTree(node.left,key);
			}else{
				Node<Integer> tem=new Node<Integer>(key);
				tem.prarent=node;
				node.left=tem;
			}
		}
	}
	
	public void test(){
		int[] collection={45,24,53,45,12,24,90};
		for(int i:collection){
			insertBinarySortTree(root,i);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		DynamicSearch ds=new DynamicSearch();
		ds.test();
	}

}
