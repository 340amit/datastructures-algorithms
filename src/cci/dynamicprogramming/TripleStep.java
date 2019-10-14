/*Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.*/
package cci.dynamicprogramming;

import java.util.Arrays;

public class TripleStep {
	
	public static void main(String[] args) {
		TripleStep ts=new TripleStep();
		System.out.println("Ways:"+ts.countWays(7));
		System.out.println("WaysD:"+ts.countWaysD(7));
	}
	
	int countWays(int n) {
		if(n<0) return 0;
		if(n==0) return 1;
		return countWays(n-1)+countWays(n-2)+countWays(n-3);
	}
	
	int countWaysD(int n) {
		int[] memo=new int[n+1];
		Arrays.fill(memo, -1);
		return countWaysDUtil(n,memo);
	}
	
	int countWaysDUtil(int n,int[] memo) {
		if(n<0) return 0;
		else if(n==0) return 1;
//		else if(memo[n]>-1) return memo[n];
		else {
			memo[n]= countWaysDUtil(n-1,memo)+countWaysDUtil(n-2,memo)+countWaysDUtil(n-3,memo);
			System.out.println("memo:"+n+"--"+memo[n]);
			return memo[n];
		}
		
	}

}
