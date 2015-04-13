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
				tem.parent=node;
				node.right=tem;
			}
		}else{//node 大于该关键字，查询左子树
			if(node.left!=null){
				insertBinarySortTree(node.left,key);
			}else{
				Node<Integer> tem=new Node<Integer>(key);
				tem.parent=node;
				node.left=tem;
			}
		}
	}
	
	public Node<Integer> createBST(){
		int[] collection={45,24,53,45,12,24,27,29,41,90,13,14,17,16,25};
		for(int i:collection){
			insertBinarySortTree(root,i);
		}
		System.out.println("二叉树构建完成");
		return root;
	}
	
	//删除某一元素
	public void deleteKey(Node<Integer> node,int key){
		if(node==null){
			System.out.println("二叉树已经为空了");
			return;
		}
		if(node.data==key){//找到该元素
			Node<Integer> parent=node.parent;//找到父节点
			boolean leftChild=node.left==null;
			boolean rightChild=node.right==null;
			if(parent==null){//说明删除的是根节点
				if(rightChild&&leftChild){//只有一个节点了
					node=null;
					root=node;
					System.out.println("删除节点:key="+key);
				}else if(leftChild ^ rightChild){
					if(!leftChild){
						root=node.left;
					}else{
						root=node.right;
					}
					root.parent=null;
					node=null;
					System.out.println("删除节点:key="+key);
				}else{
					root=node.left;
					Node<Integer> rightToEnd=node.left;
					while(rightToEnd.right!=null){//走到右孩子节点尽头
						rightToEnd=rightToEnd.right;
					}
					rightToEnd.right=node.right;
					node.right.parent=rightToEnd;
					root.parent=null; 
					node=null;
					System.out.println("删除节点:key="+key);
				}
			}else if(rightChild&&leftChild){//是叶子节点
				if(parent.data<node.data){//是右节点
					parent.right=null;
				}else{
					parent.left=null;
				}
				System.out.println("删除节点:key="+key);
			}else if(leftChild ^ rightChild){//有一个孩子
				if(!leftChild){//左孩子
					if(parent.data<node.data){//是右节点
						parent.right=node.left;
					}else{
						parent.left=node.left;
					}
					node.left.parent=parent;
				}else{//右孩子
					if(parent.data<node.data){
						parent.right=node.right;
					}else{
						parent.left=node.right;
					}
					node.right.parent=parent;
				}
				System.out.println("删除节点:key="+key);
			}else{//有两个孩子
				if(parent.data<node.data){
					parent.right=node.left;
					node.left.parent=parent;
					Node<Integer> rightToEnd=node.left;
					while(rightToEnd.right!=null){//走到右孩子节点尽头
						rightToEnd=rightToEnd.right;
					}
					rightToEnd.right=node.right;
					node.right.parent=rightToEnd;
				}else{
					parent.left=node.left;
					node.left.parent=parent;
					Node<Integer> rightToEnd=node.left;
					while(rightToEnd.right!=null){//走到右孩子节点尽头
						rightToEnd=rightToEnd.right;
					}
					rightToEnd.right=node.right;
					node.right.parent=rightToEnd;
				}
				System.out.println("删除节点:key="+key);
			}
		}
		else if(node.data<key){//在右子树里面查找
			if(node.right!=null){
				deleteKey(node.right,key);
			}else{
				System.out.println("没有节点:"+key);
			}
		}else{//在左子树里面查找
			if(node.left!=null){
				deleteKey(node.left,key);
			}else{
				System.out.println("没有节点:"+key);
			}
		}
	}
	public void deleteTree(){
		int[] collection={45,24,53,45,12,24,27,29,41,90,13,14,17,16,25,13};
		for(int i:collection){
			deleteKey(root,i);
		}
	}
	public static void main(String[] args) {
		DynamicSearch ds=new DynamicSearch();
		ds.createBST();
		//ds.deleteKey(ds.root, 24);//删除有两个孩子的节点
		//ds.deleteKey(ds.root, 17);//删除只有一个左孩子的节点
		//ds.deleteKey(ds.root, 53);//删除只有一个右孩子的节点
		//ds.deleteKey(ds.root, 41);//删除叶子节点
		//ds.deleteKey(ds.root, 1000);//删除不存在的节点
		ds.deleteTree();
	}

}
