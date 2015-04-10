package com.elementary.algorithm.little.fun;

/**
 * 一些好玩的小算法，算是自娱自乐
 * @author kaidi
 *
 */
public class LittleFun {
	//这是腾讯实习生的一个笔试题，查看当前运行平台，int位数，不能使用sizeof()
	//针对C++或者C语言, 所以用java写都需要模拟数据,java的检查太严了....
	public void findIntBitCount(){
		//int bigNumber=0xFFFFFFFFFFF;//设置一个很大的数，貌似java直接就不能编译通过
	   int tinyNumber=-1;//那就输入一个负数,看看什么时间能把这个最高位的1移处来,只要是负数都行，随便输
	   int count=1;
	   while(tinyNumber!=1){
		tinyNumber = tinyNumber>>>1; //这里要用逻辑移位...c++中有unsigned int，
	   	count++;
	   }
	   System.out.println(count);
	}

	public static void main(String[] args) {
		LittleFun lf=new LittleFun(); 
		lf.findIntBitCount();	
	}
}
