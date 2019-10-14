package cci.dynamicprogramming;

public class KnapsackDp {

	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
    int  capacity = 50; 
    int n = val.length; 
    getMaxValue(capacity, wt, val, n); 

	}
	
	public static void getMaxValue(int W,int[] wt,int[] val,int n) {
		int[][] K=new int[n+1][W+1];
		int i,j;
		for(i=0;i<=n;i++) {
			for(j=0;j<=W;j++) {
				if(i==0||j==0) 
					K[i][j]=0;
				else if(wt[i-1]<=j)
					K[i][j]=Math.max(val[i-1]+K[i-1][j-wt[i-1]], K[i-1][j]);
				else
					K[i][j]=K[i-1][j];
			}
		}
		int res=K[n][W];
		System.out.println(res);
		j=W;
		for(i=n;i>0&&res>0;i--) {
			if(res==K[i-1][j])
				continue;
			else {
				System.out.print(wt[i-1]+" ");
				res=res-val[i-1];
				j=j-wt[i-1];
			}
		
		}
	}

}
