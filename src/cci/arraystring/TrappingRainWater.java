package cci.arraystring;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
       int n = arr.length;
       System.out.println(getRainWater(arr,0,n-1));

	}
	
	static int getRainWater(int[] a,int l,int r) {
		int leftMax=0;int rightMax=0;int result=0;
		while(l<=r) {
			if(a[l]<a[r]) {
				if(leftMax<a[l]) {
					leftMax=a[l];
				}else {
					result +=leftMax-a[l];
				}
				l++;
			}else {
				if(rightMax<a[r]) {
					rightMax=a[r];
				}else {
					result +=rightMax-a[r];
				}
				r--;
			}
		}
		return result;
	}

}


//ADDCG Y - 121
