package com.elementary.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 赫夫曼树的构造
 * @author yzs
 *
 */
public class HuffmanTreeBuilder {

	List<HuffmanTree<Character>> nodeList;
	
	public HuffmanTreeBuilder(){
		initNodeList();
	}
	
	public HuffmanTree<Character> buildHuffmanTree(){
		while(nodeList.size()!=1){
			List<HuffmanTree<Character>> twoMinList=findTwoMinWeightNode();
			HuffmanTree<Character> min1=twoMinList.get(0);
			HuffmanTree<Character> min2=twoMinList.get(1);
			nodeList.remove(min1);
			nodeList.remove(min2);
			
			HuffmanTree<Character> newNode=new HuffmanTree<Character>('#',min1.weight+min2.weight);
			if(min1.data=='#'){
				newNode.leftChild=min2;
				newNode.rightChild=min1;
			}else{
				newNode.leftChild=min1;
				newNode.rightChild=min2;
			}
			nodeList.add(newNode);
		}
		HuffmanTree<Character> root=nodeList.get(0);
		return root;
	}
	//查找当前权值最小的两个节点
	private List<HuffmanTree<Character>> findTwoMinWeightNode(){
		List<HuffmanTree<Character>> twoMinList=new LinkedList<HuffmanTree<Character>>();

		HuffmanTree<Character> min1=nodeList.get(0);
		HuffmanTree<Character> min2=nodeList.get(1);
		if(min1.weight>min2.weight){
			HuffmanTree<Character> temNode=min1;
			min1=min2;
			min2=temNode;
		}
		
		if(nodeList.size()!=2){
			for(int i=2;i<nodeList.size();i++){
				HuffmanTree<Character> temNode=nodeList.get(i);
				if(temNode.weight<min1.weight){
					min2=min1;
					min1=temNode;
				}else if(temNode.weight<min2.weight){
					min2=temNode;
				}
			}
		}
		twoMinList.add(min1);
		twoMinList.add(min2);
		return twoMinList;
	}
	//设置原始节点数据
	private void initNodeList(){
		HuffmanTree<Character> A=new HuffmanTree<Character>('A', 5);
		HuffmanTree<Character> B=new HuffmanTree<Character>('B', 29);
		HuffmanTree<Character> C=new HuffmanTree<Character>('C', 7);
		HuffmanTree<Character> D=new HuffmanTree<Character>('D', 8);
		HuffmanTree<Character> E=new HuffmanTree<Character>('E', 14);
		HuffmanTree<Character> F=new HuffmanTree<Character>('F', 23);
		HuffmanTree<Character> G=new HuffmanTree<Character>('G', 3);
		HuffmanTree<Character> H=new HuffmanTree<Character>('H', 11);
		
		nodeList=new LinkedList<HuffmanTree<Character>>();
		nodeList.add(A);
		nodeList.add(B);
		nodeList.add(C);
		nodeList.add(D);
		nodeList.add(E);
		nodeList.add(F);
		nodeList.add(G);
		nodeList.add(H);
	}
	
	public static void main(String[] args){
		HuffmanTreeBuilder builder=new HuffmanTreeBuilder();
		HuffmanTree<Character> root= builder.buildHuffmanTree();
	}
}
