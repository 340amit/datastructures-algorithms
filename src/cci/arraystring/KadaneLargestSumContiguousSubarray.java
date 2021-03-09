package cci.arraystring;

// Find largest sum contiguous subarray contains negative numbers

public class KadaneLargestSumContiguousSubarray {

	public static void main(String[] args) {
		int [] a = {-2, -3, -4, -1, -2, -1, -5, -3}; 
		System.out.println(getMaxSumSub(a));
		getMaxSumSubWithIndex(a);

	}
	/* Maintain current_max=a[0] and max_so_far=a[0], 
	 * update current_max by adding each array element and finding max of it 
	 * if current_max>max_so_far update max_so_far
	 * Not applicable when array contains all negative numbers
	 */
	public static int getMaxSumSub(int[] a) {
		int current_max=a[0];
		int max_so_far=a[0];
		for(int i=1;i<a.length;i++) {
			current_max=Math.max(current_max, current_max+a[i]);
			max_so_far=Math.max(max_so_far, current_max);
		}
		return max_so_far;
	}
	/*Follow above steps.
	 * Initialise current_max=0, max_so_far=Integer.Min_Value; 
	 * Maintain three pointers for index
	 * start =0,end=0, temp=0;
	 * if current_max < 0, reset it and update temp +1 
	 * */
	public static void getMaxSumSubWithIndex(int[] a) {
		int current_max=0;
		int max_so_far=Integer.MIN_VALUE;
		int start=0,end=0,s=0;
		for(int i=0;i<a.length;i++) {
			current_max +=a[i];
			if(current_max>max_so_far) {
				max_so_far=current_max;
				start=s;
				end=i;
			}
			if(current_max<0) {
				current_max=0;
				s =i+1;
			}
		}
		System.out.println("Max Sum:"+max_so_far);
		System.out.println("Index:- start:"+start+" = end:"+end);
	}

}
