package com.elementary.algorithm.search;

/**
 * static search
 * 静态查找方法
 * @author kaidi
 *
 */
public class StaticSearch {
	
	int[] collection={05,13,19,21,37,56,64,75,80,88,92,94,95,97,98,99,99,100,102,103,104,105,106,107,111};
	
	//二分法查找
	public int binarySearch(int key){
		int high=collection.length-1;
		int low=0;
		int mid;
		int index=-1;
		while(low<=high){
			mid=(high+low)/2;
			if(collection[mid]==key){
				index=mid;
				break;
			}else{
				if(collection[mid]<key){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
		}
		return index;
	}
	
	//fibonacci 查找
	public int fibonacciSearch(int start,int end,int key){
		int index=-1;//指向查找到的元素位置，未查找到，返回-1
		int cur=start;//比较了0位元素
		for (int i = 3; cur < end; i++) {
			if (collection[cur] == key) {// 查找到元素
				index = cur;
				break;
			} else if (collection[cur] < key) {// 在右子表中查找
				if(cur==end-1){
					index=-1;
					break;//表中没有该元素，且该元素比表中数据都大
				}
				cur=start+fibonacci(i);
				if(cur>=end){
					cur=end-1;
				}
			}else {//在左子表中查找
				if((cur-start)==0){
					index=-1;
					break;//表中没有该元素，且该元素比表中数据的都小
				}
				int curStart=start+fibonacci(i-2)+1;
				index=fibonacciSearch(curStart,cur,key);
				break;
			}
		}
		return index;
	}
	//fibonacci
	private int fibonacci(int time){
		int fibonacci=0;
		if(time==1){
			fibonacci=0;
		}
		if(time==2){
			fibonacci=1;
		}
		int fn1=0;
		int fn2=1;
		for(int i=2;i<time;i++){
			fibonacci=fn1+fn2;
			fn1=fn2;
			fn2=fibonacci;
		}
		return fibonacci;
	}
	public void testFibonacciSearch(){
		int index=-1; 
		for(int i=0;i<100;i++){
			index=fibonacciSearch(0,collection.length,i);
			System.out.println(i+":"+index);
		}
	}
	public static void main(String[] args) {
		StaticSearch bs=new StaticSearch();
//		System.out.println("Search 01 :" + bs.binarySearch(1));
//		System.out.println("search 19 :" + bs.binarySearch(19));
//		System.out.println("search 21 :" + bs.binarySearch(21));
//		System.out.println("search 37 :" + bs.binarySearch(37));
//		System.out.println("search 64 :" + bs.binarySearch(64));
//		System.out.println("search 80 :" + bs.binarySearch(80));
//		System.out.println("search 88 :" + bs.binarySearch(88));
//		System.out.println("search 92 :" + bs.binarySearch(92));
//		System.out.println("search 95 :" + bs.binarySearch(95));
//		System.out.println("search 09 :" + bs.binarySearch(9));
		bs.testFibonacciSearch();
	}

}
