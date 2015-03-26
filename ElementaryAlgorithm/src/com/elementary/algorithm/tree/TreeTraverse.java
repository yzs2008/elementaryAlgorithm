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

	Tree<Character> treeRoot;
	
	public TreeTraverse(){
		treeRoot=new Tree<Character>('-');
		Tree<Character> plus=new Tree<Character>('+');
		Tree<Character> a=new Tree<Character>('a');
		Tree<Character> star=new Tree<Character>('*');
		Tree<Character> b=new Tree<Character>('b');
		Tree<Character> minis=new Tree<Character>('-');
		Tree<Character> c=new Tree<Character>('c');
		Tree<Character> d=new Tree<Character>('d');
		Tree<Character> divide=new Tree<Character>('/');
		Tree<Character> e=new Tree<Character>('e');
		Tree<Character> f=new Tree<Character>('f');
		
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
	
	public void preOrderTraverse(Tree<Character> node){

		visit(node);

		if(node.getLeftChild()!=null){
			preOrderTraverse(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			preOrderTraverse(node.getRightChild());
		}
	}
	public void inOrderTraverse(Tree<Character> node){
		if(node.getLeftChild()!=null){
			inOrderTraverse(node.getLeftChild());
		}
		visit(node);
		if(node.getRightChild()!=null){
			inOrderTraverse(node.getRightChild());
		}
	}
	public void postOrderTraverse(Tree<Character> node){
		if(node.getLeftChild()!=null){
			postOrderTraverse(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			postOrderTraverse(node.getRightChild());
		}
		visit(node);
	}
	public void preOrderTraverseS(Tree<Character> node){
		Tree<Character> curNode;
		Stack<Tree<Character>> stack=new Stack<Tree<Character>>();
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
	public void inOrderTraverseS(Tree<Character> node){
		Tree<Character> curNode=node;
		Stack<Tree<Character>> stack=new Stack<Tree<Character>>();
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
	public void inOrderTraverseS2(Tree<Character> node){
		Tree<Character> curNode=node;
		Stack<Tree<Character>> stack =new Stack<Tree<Character>>();
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
	public void postOrderTraverseS(Tree<Character> node){
		
	}
	
	private void visit(Tree<Character> node){
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
	}

}
