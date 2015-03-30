package com.elementary.algorithm.tree;

import java.util.Stack;

/**
 * @author yzs 
 * 根据树的广义表表示方法输入字符串，构建树结构
 */
public class TreeBuilder {

	//expression 表达式以#结尾 
	public TreeWithChildrenParent<Character> builder(String expression){
		//节点栈
		Stack<TreeWithChildrenParent<Character>> nodeStack =new Stack<TreeWithChildrenParent<Character>>();
		//操作符栈
		Stack<Character> opStack=new Stack<Character>();
		int index=0;
		char curInput=expression.charAt(index);
		TreeWithChildrenParent<Character> child;
		TreeWithChildrenParent<Character> parent;
		while(curInput!='#'){
			switch(curInput){
				case '('://开始获取孩子节点
					opStack.push(curInput);
					break;
				case ')'://添加孩子节点结束
				case ','://添加孩子节点
					child=nodeStack.pop();
					parent=nodeStack.pop();
					child.parent=parent;
					parent.children.add(child);
					nodeStack.push(parent);
					break;
				default://创建节点
					TreeWithChildrenParent<Character> node=new TreeWithChildrenParent<Character>(curInput);
					nodeStack.push(node);
			}
			curInput=expression.charAt(++index);
		}
		return nodeStack.pop();
	}
	
	public static void main(String[] args) {
		TreeBuilder builder=new TreeBuilder();
		TreeWithChildrenParent<Character> root= builder.builder("R(A(D,E),B,C(F(G,H,K)))#");

	}

}
