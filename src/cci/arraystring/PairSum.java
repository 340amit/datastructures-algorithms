package cci.arraystring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {

	private static final int MAX = 100000;

	public static void main(String[] args) {
		int nums[] = { 3, 3 };
		int target = 6;
		int arr[] = twoSum(nums, target);
		System.out.println(Arrays.toString(arr));
		int x = 41;
		String x1 = Integer.toString(x);
		char[] arr1 = x1.toCharArray();
		for (int i = 0; i < arr1.length; i++) {

		}

		/*
		 * final int array[]={2,-5,1,8,3,9,15}; int sum=10; boolean[] binmap=new
		 * boolean[MAX]; boolean[] binmapNegative=new boolean[MAX]; for(int
		 * i=0;i<array.length;i++){ int temp=sum-array[i]; if(temp<0){
		 * if(binmapNegative[Math.abs(temp)]){ System.out.println(temp +":"+array[i] );
		 * } }else{ if(binmap[temp]){ System.out.println(temp +":"+array[i] ); } }
		 * 
		 * if(array[i]<0){ binmapNegative[Math.abs(array[i])]=true; }else{
		 * binmap[array[i]]=true; }
		 * 
		 * }
		 */
	}

	public static int[] twoSum(int[] nums, int target) {
		Set<Integer> hs = new HashSet<Integer>();
		int l = Integer.MIN_VALUE;
		int lVal = Integer.MIN_VALUE;
		int r = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (temp > 0 && hs.contains(temp)) {
				r = i;
				lVal = temp;
			} else {
				hs.add(nums[i]);
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == lVal) {
				l = j;
				break;
			}
		}

		return new int[] { l, r };
	}
}
