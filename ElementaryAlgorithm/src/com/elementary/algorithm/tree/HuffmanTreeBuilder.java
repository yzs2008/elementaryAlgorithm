package com.elementary.algorithm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	//构造赫夫曼树
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
			min1.parent=newNode;
			min2.parent=newNode;
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
	//用来保存赫夫曼编码的字典
	Map<Character,List<Character>> huffmanCodeMap=new HashMap<Character, List<Character>>(); 
	private void getHuffmanEnCode(HuffmanTree<Character> node){
		List<Character> codeList= new LinkedList<Character>();
		preOrderTraverseHuffmanTree(node, codeList);
		for(Character c:huffmanCodeMap.keySet()){
			System.out.print(c);
			List<Character> codes=huffmanCodeMap.get(c);
			for(int i=0;i<codes.size();i++){
				System.out.print(codes.get(i));
			}
			System.out.println();
		}
	}

	//先序遍历，获取赫夫曼编码字典
	private void preOrderTraverseHuffmanTree(HuffmanTree<Character> node,List<Character> codeList){
		List<Character> curCode=new LinkedList<Character>();
		for(Character c:codeList){
			curCode.add(c);
		}
		if (node.data.charValue()=='#') {//非叶子节点
			if (node.leftChild != null) {
				curCode.add('0');
				preOrderTraverseHuffmanTree(node.leftChild, curCode);
				//左孩子访问完，要移除左孩子节点的路径影响
				curCode.remove(curCode.size()-1);
			}
			if (node.rightChild != null) {
				curCode.add('1');
				preOrderTraverseHuffmanTree(node.rightChild, curCode);
			}
		} else {
			huffmanCodeMap.put(node.data, curCode);
		}
	}
	//注，对于解码和编码均未做数据合法性检查，如果输入不合法，会照成程序运行失败
	//对输入的字符集赫夫曼编码
	public List<Character> huffmanEncoding(String input){
		List<Character> output=new LinkedList<Character>();
		for(int i=0;i<input.length();i++){
			char curInput=input.charAt(i);
			List<Character> curCode=huffmanCodeMap.get(curInput);
			for(int j=0;j<curCode.size();j++){
				output.add(curCode.get(j));
			}
		}
		return output;
	}
	//对赫夫曼编码的数据解码
	public String huffmanDecode(List<Character> input,HuffmanTree<Character> root){
		List<Character> output=new LinkedList<Character>();
		HuffmanTree<Character> pointer=root;
		int index=0;
		int length=input.size();
		while(index<length){
			char curInput=input.get(index++);
			if(curInput=='0'){
				pointer=pointer.leftChild;
			}else if(curInput=='1'){
				pointer=pointer.rightChild;
			}else{
				System.out.println("数据输入有错误!");
				break;
			}
			//到达叶子节点，找到对应的编码
			if(pointer.data!='#'){
				output.add(pointer.data);
				pointer=root;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<output.size();i++){
			sb.append(output.get(i));
		}
		return sb.toString();
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
		HuffmanTree<Character> root=builder.buildHuffmanTree();
		builder.getHuffmanEnCode(root);
		
		String input="BEEFFHHBBBAFHHABBDBCEADFFGGH";
		String output= builder.huffmanDecode(builder.huffmanEncoding(input),root);
		System.out.println("input :"+input);
		System.out.println("output:"+output);
	}
}
