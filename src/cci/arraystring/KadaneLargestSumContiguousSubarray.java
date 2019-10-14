package cci.arraystring;

// Find largest sum contiguous subarray contains negative numbers

public class KadaneLargestSumContiguousSubarray {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println(getMaxSumSub(a));
		getMaxSumSubWithIndex(a);

	}
	
	public static int getMaxSumSub(int[] a) {
		int current_max=a[0];
		int max_so_far=a[0];
		for(int i=1;i<a.length;i++) {
			current_max=Math.max(a[i], current_max+a[i]);
			max_so_far=Math.max(current_max, max_so_far);
		}
		return max_so_far;
	}
	
	public static void getMaxSumSubWithIndex(int[] a) {
		int max_ending_here=0;
		int max_so_far=Integer.MIN_VALUE;
		int start=0,end=0,s=0;
		
		for(int i=0;i<a.length;i++) {
			max_ending_here += a[i];
			if(max_so_far<max_ending_here) {
				max_so_far=max_ending_here;
				start=s;
				end=i;
			}
			if(max_ending_here<0) {
				max_ending_here=0;
				s=i+1;
			}
		}
		
		System.out.println("MAxSum:"+max_so_far);
		System.out.println("Start:"+start+"-- end:"+end);
	}

}
