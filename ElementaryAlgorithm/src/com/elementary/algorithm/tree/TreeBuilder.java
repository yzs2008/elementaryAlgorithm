package com.elementary.algorithm.tree;

import java.util.Stack;

import javax.swing.plaf.metal.MetalIconFactory.TreeFolderIcon;

/**
 * @author yzs 
 * 根据树的广义表表示方法输入字符串，构建树结构
 */
public class TreeBuilder {

	//expression 表达式以#结尾 
	public TreeWithChildrenParent<Character> buildChildrenParentTree(String expression){
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
	
	//expression must end with '#'
	public TreeSiblingChild<Character> builderSiblingChildTree(String expression){
		int index=0;
		char curInput=expression.charAt(index);
		TreeSiblingChild<Character> root;
		Stack<Character> opStack=new Stack<Character>();
		Stack<TreeSiblingChild<Character>> nodeStack=new Stack<TreeSiblingChild<Character>>();
		while(curInput!='#'){
			switch(curInput){
				case '(':
					opStack.push(curInput);
					break;
				case ')':
					char topOperator;
					do{
						topOperator=opStack.pop();
						nodeStack.pop();
					}while(topOperator!='(');
					break;
				case ',':
					opStack.push(curInput);
					break;
				default:
					TreeSiblingChild<Character> node=new TreeSiblingChild<Character>(curInput);
					if(!opStack.isEmpty() && opStack.peek()=='('){//the first child
						TreeSiblingChild<Character> parent=nodeStack.pop();
						parent.firstChild=node;
						nodeStack.push(parent);
						nodeStack.push(node);
					}else if(!opStack.isEmpty() && opStack.peek()==','){
						TreeSiblingChild<Character> sibling=nodeStack.pop();
						sibling.closedSibling=node;
						nodeStack.push(sibling);
						nodeStack.push(node);
					}	
					else{
						nodeStack.push(node);
					}
					break;
			}
			curInput=expression.charAt(++index);
		}
		root=nodeStack.pop();
		return root;
	}
	public static void main(String[] args) {
		TreeBuilder builder=new TreeBuilder();
		String expression="R(A(D,E),B,C(F(G,H,K)))#";
		TreeWithChildrenParent<Character> root= builder.buildChildrenParentTree(expression);
		TreeSiblingChild<Character> root2=builder.builderSiblingChildTree(expression);

	}

}
