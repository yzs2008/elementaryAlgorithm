/**
 * 
 */
package com.elementary.algorithm.tree;

import java.util.Stack;

/**
 * @author kaidi
 *	preorder result:
 *	-+a*b-cd/ef
 *	inorder result:
 *	a+b*c-d-e/f
 * 	post order result:
 *	abcd-*+ef/-
 */
public class TreeTraverse {

	BinaryTree<Character> treeRoot;
	
	public TreeTraverse(){
		treeRoot=new BinaryTree<Character>('-');
		BinaryTree<Character> plus=new BinaryTree<Character>('+');
		BinaryTree<Character> a=new BinaryTree<Character>('a');
		BinaryTree<Character> star=new BinaryTree<Character>('*');
		BinaryTree<Character> b=new BinaryTree<Character>('b');
		BinaryTree<Character> minis=new BinaryTree<Character>('-');
		BinaryTree<Character> c=new BinaryTree<Character>('c');
		BinaryTree<Character> d=new BinaryTree<Character>('d');
		BinaryTree<Character> divide=new BinaryTree<Character>('/');
		BinaryTree<Character> e=new BinaryTree<Character>('e');
		BinaryTree<Character> f=new BinaryTree<Character>('f');
		
		treeRoot.setLeftChild(plus);
		treeRoot.setRightChild(divide);
		
		plus.setLeftChild(a);
		plus.setRightChild(star);
		
		star.setLeftChild(b);
		star.setRightChild(minis);
		
		minis.setLeftChild(c);
		minis.setRightChild(d);
		
		divide.setLeftChild(e);
		divide.setRightChild(f); 
	}
	
	public void preOrderTraverse(BinaryTree<Character> node){

		visit(node);

		if(node.getLeftChild()!=null){
			preOrderTraverse(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			preOrderTraverse(node.getRightChild());
		}
	}
	public void inOrderTraverse(BinaryTree<Character> node){
		if(node.getLeftChild()!=null){
			inOrderTraverse(node.getLeftChild());
		}
		visit(node);
		if(node.getRightChild()!=null){
			inOrderTraverse(node.getRightChild());
		}
	}
	public void postOrderTraverse(BinaryTree<Character> node){
		if(node.getLeftChild()!=null){
			postOrderTraverse(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			postOrderTraverse(node.getRightChild());
		}
		visit(node);
	}
	public void preOrderTraverseS(BinaryTree<Character> node){
		BinaryTree<Character> curNode;
		Stack<BinaryTree<Character>> stack=new Stack<BinaryTree<Character>>();
		stack.push(node);
		while(!stack.empty()){
			curNode=stack.pop();
			visit(curNode);
			if(curNode.getRightChild()!=null){
				stack.push(curNode.getRightChild());
			}
			if(curNode.getLeftChild()!=null){
				stack.push(curNode.getLeftChild());
			}
		}
	}
	public void inOrderTraverseS(BinaryTree<Character> node){
		BinaryTree<Character> curNode=node;
		Stack<BinaryTree<Character>> stack=new Stack<BinaryTree<Character>>();
		stack.push(node);
		boolean back=false;
		while(!stack.empty()){
			while(curNode.getLeftChild()!=null && !back){
				stack.push(curNode.getLeftChild());
				curNode=curNode.getLeftChild();
			}
			curNode=stack.pop();
			visit(curNode);
			if(curNode.getRightChild()!=null){
				stack.push(curNode.getRightChild());
				curNode=curNode.getRightChild();
				back=false;
			}else{
				back=true;
			}
		}
	}
	public void inOrderTraverseS2(BinaryTree<Character> node){
		BinaryTree<Character> curNode=node;
		Stack<BinaryTree<Character>> stack =new Stack<BinaryTree<Character>>();
		while(!stack.empty()||curNode!=null){
			if(curNode!=null){
				stack.push(curNode);
				curNode=curNode.leftChild;
			}else{
				curNode=stack.pop();
				visit(curNode);
				curNode=curNode.rightChild;
			}
		}
	}
	public void postOrderTraverseS(BinaryTree<Character> node){
		BinaryTree<Character> curNode=node;
		Stack<BinaryTree<Character>> stack=new Stack<BinaryTree<Character>>();
		stack.push(curNode);
		while(!stack.empty()){
			if(curNode.leftChild!=null){
				stack.push(curNode.leftChild);
				curNode=curNode.leftChild;
			}
			curNode=stack.pop();
			visit(curNode);
			if(curNode.rightChild!=null){
				stack.push(curNode.rightChild);
				curNode=curNode.rightChild;
			}
		}
	}
	
	private void visit(BinaryTree<Character> node){
		System.out.print(node.getData());
	}
	public static void main(String[] args) {
		TreeTraverse traverse=new TreeTraverse();
		
		System.out.println("preorder result:");
		traverse.preOrderTraverse(traverse.treeRoot);
		System.out.println("\ninorder result:");
		traverse.inOrderTraverse(traverse.treeRoot);
		System.out.println("\npost order result:");
		traverse.postOrderTraverse(traverse.treeRoot);
		
		System.out.println("\npreorder with no recursive result:");
		traverse.preOrderTraverseS(traverse.treeRoot);
		
		System.out.println("\ninorder with no recursive result:");
		traverse.inOrderTraverseS(traverse.treeRoot);

		System.out.println("\ninorder with no recursive result:");
		traverse.inOrderTraverseS2(traverse.treeRoot);

		System.out.println("\npost order with no recursive result:");
		traverse.postOrderTraverseS(traverse.treeRoot);
	}

}
