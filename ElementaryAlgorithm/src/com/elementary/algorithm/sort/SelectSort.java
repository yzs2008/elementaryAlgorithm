package com.elementary.algorithm.sort;


/**
 * 选择排序
 * @author yzs
 *
 */
public class SelectSort {

	int[] data={49,38,65,97,76,13,27,49};
	//int[] data={29};
	//堆排序，选择排序的经典代表
	public void heapSort(){
		int length=data.length;
		for(int i=length;i>0;i--){
			heapAdjust(i);
			//showResult();//查看每一次筛选的结果
			int prey=data[0];
			data[0]=data[i-1];
			data[i-1]=prey;
		}
		showResult();
	}
	//堆排序筛选过程
	private void heapAdjust(int length){//length>=1
		int cur=(length-1)/2;//最后一个非叶子节点
		for(;cur>=0;cur--){//从最后一个非叶子节点一直筛选到根节点
			int k=0;//用来指示下一个筛选是左子树(1)还是右子树(2)
			for(int i=cur;i<length;i=2*i+k){
				int left=i*2+1;//当前节点的左孩子
				int right=i*2+2;//当前节点的右孩子
				if(right>=length){
					right=left;
				}
				if(left>=length){//说明到达叶子节点
					break;
				}
				if(data[left]<=data[right]){//左子树小于等于右子树,等于可能是因为没有右孩子照成的
					if(data[left]>=data[i]){//已经是最小堆，不需要调整了
						break;
					}else{//将左孩子的值（小）移动到父节点
						int tem=data[i];
						data[i]=data[left];
						data[left]=tem;
						k=1;//接着调整左子树
					}
				}else{//左孩子大于右孩子
					if(data[right]>=data[i]){
						break;
					}else{
						int tem=data[i];
						data[i]=data[right];
						data[right]=tem;
						k=2;
					}
				}
			}
		}
	}
	
	//简单直接选择排序，适用于少元素，而且需要稳定排序算法的情况
	public void simpleSelectSort(){
		int length=data.length;
		for(int i=0;i<length;i++){
			int cur=data[i];
			int curIndex=i;
			for(int j=i+1;j<length;j++){
				if(data[j]<cur){//找到最小值
					cur=data[j];
					curIndex=j;//保存最小值的索引位置
				}
			}
			data[curIndex]=data[i];
			data[i]=cur;
		}
		showResult();
	}
	private void showResult(){
		System.out.print("the data is :{");
		for(int i:data){
			System.out.print(i+" ");
		}
		System.out.print("}");
		System.out.println();
	}
	public static void main(String[] args){
		SelectSort ss=new SelectSort();
		ss.showResult();
		//ss.simpleSelectSort();
		ss.heapSort();
	}
}
