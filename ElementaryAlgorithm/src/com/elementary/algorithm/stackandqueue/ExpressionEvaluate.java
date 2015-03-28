package com.elementary.algorithm.stackandqueue;

import java.util.Stack;

import com.sun.javafx.fxml.expression.Expression;

/**
 * 简单表达式求值计算
 * @author yzs
 *
 */
public class ExpressionEvaluate {
	int[][] priorityPool;
	char[] operatorPool={'+','-','*','/','(',')','#'};
	public ExpressionEvaluate(){
		int length=operatorPool.length;
		priorityPool=new int[length][length];
		initPriorityPool();
	}
	
	public double evaluate(String expression){
		double result=0;
		Stack<Double> numberStack =new Stack<Double>();
		Stack<Character> operatorStack=new Stack<Character>(); 
		operatorStack.push('#');
		
		boolean isDone=(expression==null||expression=="");
		int index=0;
		while(!isDone){
			char curChar=expression.charAt(index);
			//数字 压栈
			if(isNumber(curChar)){
				numberStack.push((double)curChar);
			}else if(isOperator(curChar)){
				int priority=getPriority(curChar, operatorStack.peek());
				switch(priority){
					case 0://相等，是括号，需要弹出栈
						operatorStack.pop();
						index++;
						break;
					case 1:
						double left=numberStack.pop();
						double right=numberStack.pop();
						char op=operatorStack.pop();
						double temResult=precede(left, op, right);
						numberStack.push(temResult);
						break;
					case -1:
						operatorStack.push(curChar);
						index++;
						break;
					case 2://错误表达式
						break;
				}
			}else{
				//非法表达式
				isDone=true;
			}
		}
		result=numberStack.pop();
		return result;
	}
	private double precede(double left,char op,double right){
		double result=0;
		switch(op){
			case '+':
				result=left+right;
				break;
			case '-':
				result=left-right;
				break;
			case '*':
				result=left*right;
				break;
			case '/':
				result=left/right;
				break;
		}
		return result;
	}
	private boolean isOperator(char input){
		boolean yes=false;
		for(int i=0;i<operatorPool.length;i++){
			if(operatorPool[i]==input){
				yes=true;
				break;
			}
		}
		return yes;
	}
	private boolean isNumber(char input){
		boolean yes=false;
		int inputASCI=(int)input;
		final int one='0';
		final int nine='9';
		if(inputASCI<=nine && inputASCI>=one){
			yes=true;
		}
		return yes;
	}

	private int getPriority(char opLeft,char opRight){
		int priority=2;
		int leftIndex=getOperatorIndex(opLeft);
		int rightIndex=getOperatorIndex(opRight);
		if(leftIndex==-1 || rightIndex==-1){
			return priority;
		}
		return priorityPool[leftIndex][rightIndex];
	}
	private int getOperatorIndex(char op){
		int index=-1;
		for(int i=0;i<operatorPool.length;i++){
			if(operatorPool[i]==op){
				index=i;
				break;
			}
		}
		return index;
	}
	private void initPriorityPool(){
		priorityPool[0][0]=1;
		priorityPool[0][1]=1;
		priorityPool[0][2]=-1;
		priorityPool[0][3]=-1;
		priorityPool[0][4]=-1;
		priorityPool[0][5]=1;
		priorityPool[0][6]=1;

		priorityPool[1][0]=1;
		priorityPool[1][1]=1;
		priorityPool[1][2]=-1;
		priorityPool[1][3]=-1;
		priorityPool[1][4]=-1;
		priorityPool[1][5]=1;
		priorityPool[1][6]=1;

		priorityPool[2][0]=1;
		priorityPool[2][1]=1;
		priorityPool[2][2]=1;
		priorityPool[2][3]=1;
		priorityPool[2][4]=-1;
		priorityPool[2][5]=1;
		priorityPool[2][6]=1;

		priorityPool[3][0]=1;
		priorityPool[3][1]=1;
		priorityPool[3][2]=1;
		priorityPool[3][3]=1;
		priorityPool[3][4]=-1;
		priorityPool[3][5]=1;
		priorityPool[3][6]=1;

		priorityPool[4][0]=-1;
		priorityPool[4][1]=-1;
		priorityPool[4][2]=-1;
		priorityPool[4][3]=-1;
		priorityPool[4][4]=-1;
		priorityPool[4][5]=0;
		priorityPool[4][6]=2;

		priorityPool[5][0]=1;
		priorityPool[5][1]=1;
		priorityPool[5][2]=1;
		priorityPool[5][3]=1;
		priorityPool[5][4]=2;
		priorityPool[5][5]=1;
		priorityPool[5][6]=1;

		priorityPool[6][0]=-1;
		priorityPool[6][1]=-1;
		priorityPool[6][2]=-1;
		priorityPool[6][3]=-1;
		priorityPool[6][4]=-1;
		priorityPool[6][5]=2;
		priorityPool[6][6]=0;
	}
	public static void main(String[] args) {
		ExpressionEvaluate ee=new ExpressionEvaluate();
		double result=ee.evaluate("3*(7-2)");
		System.out.println(result);
	}

}
