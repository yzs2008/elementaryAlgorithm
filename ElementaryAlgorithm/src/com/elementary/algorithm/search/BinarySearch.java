package com.elementary.algorithm.search;

/**
 * binary search
 * @author kaidi
 *
 */
public class BinarySearch {
	
	int[] collection={05,13,19,21,37,56,64,75,80,88,92};
	
	public int search(int key){
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
	
	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		System.out.println("search 01 :"+bs.search(1));
		System.out.println("search 19 :"+bs.search(19));
		System.out.println("search 21 :"+bs.search(21));
		System.out.println("search 37 :"+bs.search(37));
		System.out.println("search 64 :"+bs.search(64));
		System.out.println("search 80 :"+bs.search(80));
		System.out.println("search 88 :"+bs.search(88));
		System.out.println("search 92 :"+bs.search(92));
		System.out.println("search 95 :"+bs.search(95));
		System.out.println("search 09 :"+bs.search(9));

	}

}
