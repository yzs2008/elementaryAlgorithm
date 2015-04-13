package com.elementary.algorithm.search;

/**
 * 查看异或运算
 * @author kaidi
 *
 */
public class ExclusiveOR {

	public static void main(String[] args) {
		boolean one=false;
		boolean two=false;
		boolean result=one ^ two;
		System.out.println(result);
		one=true;
		result=one ^ two;
		System.out.println(result);
	}

}
