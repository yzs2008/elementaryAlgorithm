package com.elementary.algorithm.tree;

import java.util.Stack;

/**
 * @author yzs 
 * 根据树的广义表表示方法输入字符串，构建树结构
 */
public class TreeBuilder {

	//expression 表达式以#结尾 
	public void builder(String expression){
		//节点栈
		Stack<TreeWithChildrenParent<Character>> nodeStack =new Stack<TreeWithChildrenParent<Character>>();
		//操作符栈
		Stack<Character> opStack=new Stack<Character>();
		int index=0;
		char curInput=expression.charAt(index);
		while(curInput!='#'){
			switch(curInput){
				case '('://开始获取孩子节点
					opStack.push(curInput);
					curInput=expression.charAt(++index);
					break;
				case ')'://添加孩子节点结束
					curInput=expression.charAt(++index);
					break;
				case ','://添加孩子节点
					TreeWithChildrenParent<Character> child=nodeStack.pop();
					TreeWithChildrenParent<Character> parent=nodeStack.pop();
					parent.children.add(child);
					nodeStack.push(parent);
					curInput=expression.charAt(++index);
					break;
				default://创建节点
					TreeWithChildrenParent<Character> node=new TreeWithChildrenParent<Character>(curInput);
					nodeStack.push(node);
					curInput=expression.charAt(++index);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
