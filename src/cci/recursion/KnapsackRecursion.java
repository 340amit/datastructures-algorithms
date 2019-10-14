package cci.recursion;

public class KnapsackRecursion {

	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
    int  capacity = 50; 
    int n = val.length; 
    System.out.println(getMaxValue(capacity, wt, val, n)); 

	}
	
	public static int getMaxValue(int capacity,int[] wt, int[] val,int n) {
		if(n==0 || capacity==0)
			return 0;
		if(wt[n-1]>capacity)
			return getMaxValue(capacity,wt,val,n-1);
		else
			return Math.max(val[n-1]+getMaxValue(capacity-wt[n-1],wt,val,n-1), getMaxValue(capacity,wt,val,n-1));
	}

}
