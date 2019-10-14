//A[i]=i
package cci.dynamicprogramming;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int getMagicIndex(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==i) return i;
		}
		
		return -1;
	}
	
	//Array sorted - use binary search
	
	int getMagicIndexBS(int[] arr) {
		int start=0;
		int end=arr.length-1;
		return getMagicIndexBSUtil(arr,start,end);
	}
	
	int getMagicIndexBSUtil(int[] arr,int start,int end) {
		
		if(end<start) return -1;
		
		int mid=(start+end)/2;
		if(arr[mid]==mid) {
			return mid;
		}else if(arr[mid]>mid) {
			return getMagicIndexBSUtil(arr,start,mid-1);
		}else {
			return getMagicIndexBSUtil(arr,mid+1,end);
		}
		
	}
	
	//Array is sorted but have duplicates
	int getMagicIndexBS2(int[] arr) {
		int start=0;
		int end=arr.length-1;
		return getMagicIndexBSUtil(arr,start,end);
	}
	
	int getMagicIndexBSUtil2(int[] arr,int start,int end) {
		
		if(end<start) return -1;
		
		int mid=(start+end)/2;
		int midVal=arr[mid];
		if(midVal==mid) {
			return mid;
		}
		
		//search left
		int lIndex=Math.min(mid-1, midVal);
		int left=getMagicIndexBSUtil2(arr,start,lIndex);
		if(left>=0) return left;
		
		int rIndex=Math.max(mid+1, midVal);
		int right=getMagicIndexBSUtil2(arr,rIndex,end);
		return right;
		
	}
	

}
