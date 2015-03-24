/**
 * 
 */
package com.elementary.algorithm.collection;

/**
 * @author yzs
 *
 */
public class Permutation {

	/**
	 * �����ơ����㼯�ϵ�ȫ����
	 * ��˵���� ���ϳ���ֻ��1����ȫ����Ϊ����	{a}-->a
	 * ���ϳ���Ϊ2��{a,b}-->ab;ba;���Ϊ�����ڵ�һ��Ԫ��a��ͷ������������Ԫ��{b}��ȫ���У�����
	 * �ڵڶ���Ԫ��b��ͷ������Ԫ�� {a}��ȫ���м��ϣ�
	 * 
	 * @param collection ����
	 * @param curIndex ��ǰȡ���ϵĵڼ���Ԫ����Ϊ��ͷ,0�ǵ�һ��Ԫ��
	 * @param theN ������Ԫ�ظ���,1����N��
	 */
	public void permutation(int[] collection,int curIndex,int theN){
		if(curIndex==theN){
			//��ǰ������ֻ��һ��Ԫ�أ�����ȫ����Ϊ����
			show(collection);
			return;
		}else{
			for(int k=curIndex;k<theN;k++){
				//C={A,B,C}
				int tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
				//C={B,A,C}
				permutation(collection,curIndex+1,theN);//{B}U{A,C}
				
				//��ԭ������������һ���
				tem=collection[k];
				collection[k]=collection[curIndex];
				collection[curIndex]=tem;
			}
		}
	}
	private void show(int[] collection){
		System.out.println();
		for(int i:collection){
			System.out.print(i);
		}
	}
	
	public static void main(String[] args) {
		int[] collection={1,2,3,4};
		Permutation permutation=new Permutation();
		permutation.permutation(collection, 0, 4);
	}

}
